/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.uamp.utils;

import android.media.MediaMetadata;

import com.example.android.uamp.model.MusicProviderSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleMusicProviderSource implements MusicProviderSource {

    private List<MediaMetadata> mData = new ArrayList<>();

    public void add(String title, String album, String artist, String genre, String source,
                    String iconUrl, long trackNumber, long totalTrackCount, long durationMs) {
        String id = String.valueOf(source.hashCode());

        mData.add(new MediaMetadata.Builder()
                .putString(MediaMetadata.METADATA_KEY_MEDIA_ID, id)
                .putString(MusicProviderSource.CUSTOM_METADATA_TRACK_SOURCE, source)
                .putString(MediaMetadata.METADATA_KEY_ALBUM, album)
                .putString(MediaMetadata.METADATA_KEY_ARTIST, artist)
                .putLong(MediaMetadata.METADATA_KEY_DURATION, durationMs)
                .putString(MediaMetadata.METADATA_KEY_GENRE, genre)
                .putString(MediaMetadata.METADATA_KEY_ALBUM_ART_URI, iconUrl)
                .putString(MediaMetadata.METADATA_KEY_TITLE, title)
                .putLong(MediaMetadata.METADATA_KEY_TRACK_NUMBER, trackNumber)
                .putLong(MediaMetadata.METADATA_KEY_NUM_TRACKS, totalTrackCount)
                .build());
    }

    @Override
    public Iterator<MediaMetadata> iterator() {
        return mData.iterator();
    }

}
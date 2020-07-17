/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.example.android.homestorage.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the HomeStorage app.
 */

public final class StorageContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StorageContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.homestorage.data";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_STORAGE_BINS = "storage_table";




    /**
     * Inner class that defines constant values for the HomeStorage database table.
     * Each entry in the table represents a single storage bin.
     */
    public static final class StorageEntry implements BaseColumns {

        /** The content URI to access the storage bins data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_STORAGE_BINS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of storage bins.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STORAGE_BINS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single storage bin.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STORAGE_BINS;



        /** Name of database table for storage */
        public final static String TABLE_NAME = "storage_table";

        /**
         * Unique ID number for the storage bin (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the Room.
         *
         * Type: TEXT
         */
        public final static String COLUMN_STORAGE_ROOM ="room";

        /**
         * Bin code of the storage.
         *
         * Type: TEXT
         */
        public final static String COLUMN_STORAGE_BIN = "bin";

        /**
         * Description of the bin storage.
         *
         *
         * Type: TEXT
         */
        public final static String COLUMN_STORAGE_DESCRIPTION = "description";

        /**
         * Picture of the storage bin.
         *
         * Type: TEXT
         */
        public final static String COLUMN_STORAGE_PICTURE = "picture";

        /**
         * Status of the storage bin - availability.
         *
         * Status of storage bin can be only {@link #STATUS_CHECKED_IN} which is available
         * and {@link #STATUS_CHECKED_OUT} which is not available.
         *
         * Type: boolean
         */
        public final static String COLUMN_STORAGE_AVAILABILITY = "availability";

        /**
         * Possible values for the availability of the storage product.
         */
        public static final boolean STATUS_CHECKED_IN = true;
        public static final boolean STATUS_CHECKED_OUT = false;

    }

}


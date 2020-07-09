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

import android.provider.BaseColumns;

/**
 * API Contract for the HomeStorage app.
 */

public final class StorageContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StorageContract() {}

    /**
     * Inner class that defines constant values for the HomeStorage database table.
     * Each entry in the table represents a single storage bin.
     */
    public static final class StorageEntry implements BaseColumns {

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


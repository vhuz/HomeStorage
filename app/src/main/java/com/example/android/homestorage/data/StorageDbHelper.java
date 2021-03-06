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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.homestorage.data.StorageContract.StorageEntry;

/**
 * Database helper for Pets app. Manages database creation and version management.
 */
public class StorageDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = StorageDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "home_storage.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link StorageDbHelper}.
     *
     * @param context of the app
     */
    public StorageDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_STORAGE_TABLE =  "CREATE TABLE " + StorageEntry.TABLE_NAME + " ("
                + StorageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StorageEntry.COLUMN_STORAGE_ROOM + " TEXT NOT NULL, "
                + StorageEntry.COLUMN_STORAGE_BIN + " TEXT NOT NULL, "
                + StorageEntry.COLUMN_STORAGE_DESCRIPTION + " TEXT NOT NULL, "
                + StorageEntry.COLUMN_STORAGE_PICTURE + " TEXT, "
                + StorageEntry.COLUMN_STORAGE_AVAILABILITY + " BOOLEAN NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_STORAGE_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
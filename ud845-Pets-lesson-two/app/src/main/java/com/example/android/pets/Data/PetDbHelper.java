package com.example.android.pets.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PC on 04-11-2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {
    //Name of the database file
    private static final String DATABASE_NAME="shelter.db";
    //Database Version.If I've to change the database schema then I've to increment the
    //database version
    private static final int DATABASE_VERSION=1;
    public PetDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE pets(_id INTEGER PRIMARY KEY,name TEXT,weight INTEGER,
        //Create a string that contains the SQl statement to create the pets table
        String SQL_CREATE_PETS_TABLE="CREATE TABLE "+PetContract.PetEntry.TABLE_NAME+"("
                + PetContract.PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +PetContract.PetEntry.COLUMN_PET_NAME+" TEXT NON NULL,"
                + PetContract.PetEntry.COLUMN_PET_BREED+" TEXT,"
                + PetContract.PetEntry.COLUMN_PET_WEIGHT+" INTGER NOT NULL DEFAULT 0,"
                + PetContract.PetEntry.COLUMN_PET_GENDER+" INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

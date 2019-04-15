package com.ilatyphi95.populatespinnerwithsqlitedatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {Food.class}, version = 1, exportSchema = false)
public abstract class FoodDatabase extends RoomDatabase {

    private static final String LOG_TAG = FoodDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "spinner_database";
    private static FoodDatabase sInstance;


    public static FoodDatabase getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (FoodDatabase.class) {
                if(sInstance == null) {
                    Log.d(LOG_TAG, "Creating new database instance");
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            FoodDatabase.class, FoodDatabase.DATABASE_NAME)
                            .build();
                }
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract FoodDao foodDao();
}

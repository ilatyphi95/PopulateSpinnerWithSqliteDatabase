package com.ilatyphi95.populatespinnerwithsqlitedatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Food {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "food_type")
    public String foodType;
}

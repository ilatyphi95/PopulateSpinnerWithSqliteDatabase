package com.ilatyphi95.populatespinnerwithsqlitedatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Food {

    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "food_name")
    private String foodName;

    @Ignore
    public Food(String foodName) {
        this.foodName = foodName;
    }

    public Food(int id, String foodName) {
        this(foodName);
        this.id = id;
    }
}

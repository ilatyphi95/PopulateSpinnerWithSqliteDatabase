package com.ilatyphi95.populatespinnerwithsqlitedatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert
    void insert(Food food);

    @Query("SELECT * FROM food ORDER BY food_type ASC")
    LiveData<List<Food>> loadFood();

}

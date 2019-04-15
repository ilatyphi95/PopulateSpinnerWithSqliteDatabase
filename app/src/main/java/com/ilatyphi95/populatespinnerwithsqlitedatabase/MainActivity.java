package com.ilatyphi95.populatespinnerwithsqlitedatabase;

import android.arch.persistence.room.Database;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String FIRST_LAUNCH = "first_launch";
    SharedPreferences mPreferences;
    FoodDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spnFoodList = findViewById(R.id.spn_food_list);
        mPreferences = getPreferences(MODE_PRIVATE);

        mDb = FoodDatabase.getsInstance(this);

        Boolean firstLaunch = mPreferences.getBoolean(FIRST_LAUNCH, true);
        if(firstLaunch) {
            mDb.foodDao().insert(new Food("Pizza"));
            mDb.foodDao().insert(new Food("Salad"));
            mDb.foodDao().insert(new Food("Soup"));
            mDb.foodDao().insert(new Food("Rice with Sauce"));
            mDb.foodDao().insert(new Food("Noodles"));
            mDb.foodDao().insert(new Food("Baked Potatoes"));
            mDb.foodDao().insert(new Food("Bulgar"));
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putBoolean(FIRST_LAUNCH, false);
            editor.apply();
        }

    }
}

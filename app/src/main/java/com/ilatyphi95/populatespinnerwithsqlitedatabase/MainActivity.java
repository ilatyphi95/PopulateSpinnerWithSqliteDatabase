package com.ilatyphi95.populatespinnerwithsqlitedatabase;

import android.arch.persistence.room.Database;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

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
            List<Food> foods = new ArrayList<>();
            foods.add(new Food("Pizza"));
            foods.add(new Food("Salad"));
            foods.add(new Food("Soup"));
            foods.add(new Food("Rice with Sauce"));
            foods.add(new Food("Noodles"));
            foods.add(new Food("Baked Potatoes"));
            foods.add(new Food("Bulgar"));

            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putBoolean(FIRST_LAUNCH, false);
            editor.apply();

            new InserAsyncTask(foods);


        }

        List<String> data = new ArrayList<>();
        data.add("Dummy data");

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, data);

        spnFoodList.setAdapter(adapter);

    }

    private class InserAsyncTask extends AsyncTask <Void, Void, Void> {
        List<Food> mFoods;
        public InserAsyncTask(List<Food> foods) {
            mFoods = foods;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            for(Food food : mFoods) {
                mDb.foodDao().insert(food);
            }
            return null;
        }
    }
}

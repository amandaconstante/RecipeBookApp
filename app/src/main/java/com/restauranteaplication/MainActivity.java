package com.restauranteaplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.restauranteaplication.adapter.FoodAdapter;
import com.restauranteaplication.databinding.ActivityMainBinding;
import com.restauranteaplication.model.Food;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Food> foodList = new ArrayList<>();
    private ActivityMainBinding binding;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerViewFood = binding.RecyclerViewFood;
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFood.setHasFixedSize(true);
        foodAdapter = new FoodAdapter(foodList, this);
        recyclerViewFood.setAdapter(foodAdapter);
        getFood();
    }

    private void getFood(){
        Food food1 = new Food(
                R.drawable.food1,
                "Food 1",
                "Descrição da 1a comida! Ingredientes e etc e blablabla",
                "$ 10"
        );
        foodList.add(food1);

        Food food2 = new Food(
                R.drawable.food2,
                "Food 2",
                "Descrição da 2a comida! Ingredientes e etc e blablabla",
                "$ 20"
        );
        foodList.add(food2);

        Food food3 = new Food(
                R.drawable.food3,
                "Food 3",
                "Descrição da 3a comida! Ingredientes e etc e blablabla",
                "$ 30"
        );
        foodList.add(food3);

        Food food4 = new Food(
                R.drawable.food4,
                "Food 4",
                "Descrição da 4a comida! Ingredientes e etc e blablabla",
                "$ 40"
        );
        foodList.add(food4);

        Food food5 = new Food(
                R.drawable.food5,
                "Food 5",
                "Descrição da 5a comida! Ingredientes e etc e blablabla",
                "$ 50"
        );
        foodList.add(food5);

    }
}
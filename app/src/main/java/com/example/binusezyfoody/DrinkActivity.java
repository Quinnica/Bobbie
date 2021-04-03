package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.binusezyfoody.adapter.DrinkAdapter;
import com.example.binusezyfoody.model.Drink;
import com.example.binusezyfoody.storage.DrinkStorage;

import java.io.Serializable;
import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private DrinkAdapter drinkAdapter;
    private Button orderBtnDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        this.setTitle(this.getTitle() + ": Drinks");


        listView = findViewById(R.id.drinksList);
        ArrayList<Drink> drinksList = new ArrayList<Drink>();
        drinkAdapter = new DrinkAdapter(this, 0, drinksList);
        listView.setAdapter(drinkAdapter);
        drinkAdapter.addAll(DrinkStorage.getInstance());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent orderDrinkIntent = new Intent(getApplicationContext(), OrderActivity.class);
                orderDrinkIntent.putExtra("drink", (Serializable) listView.getItemAtPosition(i));
                startActivity(orderDrinkIntent);
            }
        });

        orderBtnDrink = findViewById(R.id.orderBtnDrink);

        orderBtnDrink.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == orderBtnDrink) {
            Intent intent = new Intent(this, MyOrderActivity.class);
            startActivity(intent);
        }
    }
}
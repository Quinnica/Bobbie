package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.binusezyfoody.model.Drink;
import com.example.binusezyfoody.storage.DrinkStorage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button drinksBtn, orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDrinksData();

        drinksBtn = findViewById(R.id.drinksBtn);
        orderBtn = findViewById(R.id.orderBtn);

        drinksBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);
    }

    public void initDrinksData(){
        if(DrinkStorage.getInstance().isEmpty()) {
            Drink water = new Drink("Air Mineral", 5000);
            Drink mangoJuice = new Drink("Jus Mangga", 10000);
            Drink appleJuice = new Drink("Jus Apel", 8000);
            Drink avocadoJuice = new Drink("Jus Alpukat", 15000);

            DrinkStorage.getInstance().add(water);
            DrinkStorage.getInstance().add(mangoJuice);
            DrinkStorage.getInstance().add(appleJuice);
            DrinkStorage.getInstance().add(avocadoJuice);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == drinksBtn){
            Toast.makeText(this, "Drinks", Toast.LENGTH_SHORT).show();
            Intent drinksIntent = new Intent(this, DrinkActivity.class);
            this.startActivity(drinksIntent);
        } else if(view == orderBtn) {
            Intent intent = new Intent(this, MyOrderActivity.class);
            startActivity(intent);
        }
    }
}
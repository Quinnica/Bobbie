package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfoody.model.Drink;
import com.example.binusezyfoody.model.Order;
import com.example.binusezyfoody.storage.OrderStorage;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private Drink drink;
    private Button buyDrinkBtn, myOrderBtn, orderMoreBtn;
    private TextView orderDrinkTxt, orderDrinkPriceTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        this.setTitle(this.getTitle() + ": Order");

        drink = (Drink) getIntent().getSerializableExtra("drink");
        Toast.makeText(this, drink.getName(), Toast.LENGTH_SHORT).show();

        orderDrinkTxt = findViewById(R.id.orderDrinkTxt);
        orderDrinkPriceTxt = findViewById(R.id.orderDrinkPriceTxt);
        orderDrinkTxt.setText(drink.getName());
        orderDrinkPriceTxt.setText(Integer.toString(drink.getPrice()));

        buyDrinkBtn = (Button) findViewById(R.id.buyDrinkBtn);
        myOrderBtn = (Button) findViewById(R.id.myOrderBtn);
        orderMoreBtn = (Button) findViewById(R.id.orderMoreBtn);

        buyDrinkBtn.setOnClickListener(this);
        myOrderBtn.setOnClickListener(this);
        orderMoreBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == orderMoreBtn) {
            Intent intent = new Intent(getApplicationContext(), DrinkActivity.class);
            startActivity(intent);
        } else if(view == buyDrinkBtn) {
            TextView quantity = findViewById(R.id.qtyOrderTxt);
            int qty = 0;
            if(!quantity.getText().toString().isEmpty()){
                 qty = Integer.parseInt(quantity.getText().toString());
            }
            if(qty == 0) {
                Toast.makeText(this, "Quantity cannot be 0", Toast.LENGTH_SHORT).show();
            }else {
                Order newOrder = new Order(drink, qty);
                OrderStorage.getInstance().add(newOrder);
                Toast.makeText(this, "Order Successful!", Toast.LENGTH_SHORT).show();
            }
        } else if(view == myOrderBtn) {
            Intent intent = new Intent(this, MyOrderActivity.class);
            startActivity(intent);
        }
    }

}
package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfoody.adapter.DrinkAdapter;
import com.example.binusezyfoody.adapter.MyOrderAdapter;
import com.example.binusezyfoody.model.Drink;
import com.example.binusezyfoody.model.Order;
import com.example.binusezyfoody.storage.DrinkStorage;
import com.example.binusezyfoody.storage.OrderStorage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPayNow;
    private ListView myOrderListView;
    private MyOrderAdapter myOrderAdapter;
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        this.setTitle(this.getTitle() + ": My Order");

        myOrderListView = findViewById(R.id.myOrderListView);
        ArrayList<Order> orderArrayList = new ArrayList<>();
        myOrderAdapter = new MyOrderAdapter(this, 0, orderArrayList);
        myOrderListView.setAdapter(myOrderAdapter);
        myOrderAdapter.addAll(OrderStorage.getInstance());

        totalPrice = findViewById(R.id.totalPrice);
        int total = 0;
        if(!OrderStorage.getInstance().isEmpty()){
            for (Order order: OrderStorage.getInstance()) {
                int temp = order.getQuantity() * order.getDrink().getPrice();
                total += temp;
            }
        }
        totalPrice.setText("Total Price: Rp. " + Integer.toString(total));

        btnPayNow = findViewById(R.id.payBtn);
        btnPayNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnPayNow) {
            if(OrderStorage.getInstance().isEmpty()) {
                Toast.makeText(this, "Make an order first!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, OrderCompleteActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

}
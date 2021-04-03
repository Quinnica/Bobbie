package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.binusezyfoody.adapter.MyOrderAdapter;
import com.example.binusezyfoody.adapter.OrderCompleteAdapter;
import com.example.binusezyfoody.model.Order;
import com.example.binusezyfoody.storage.OrderStorage;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMainMenu;
    private ListView listView;
    private OrderCompleteAdapter orderCompleteAdapter;
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        this.setTitle(this.getTitle() + ": Order Complete");

        listView = findViewById(R.id.completeList);
        ArrayList<Order> orderArrayList = new ArrayList<>();
        orderCompleteAdapter = new OrderCompleteAdapter(this, 0, orderArrayList);
        listView.setAdapter(orderCompleteAdapter);
        orderCompleteAdapter.addAll(OrderStorage.getInstance());

        totalPrice = findViewById(R.id.totalComplete);
        int total = 0;
        if(!OrderStorage.getInstance().isEmpty()){
            for (Order order: OrderStorage.getInstance()) {
                int temp = order.getQuantity() * order.getDrink().getPrice();
                total += temp;
            }
        }
        totalPrice.setText("Total Price: Rp. " + Integer.toString(total));

        btnMainMenu = findViewById(R.id.mainMenuBtn);
        btnMainMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnMainMenu){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            OrderStorage.getInstance().clear();
        }
    }
}
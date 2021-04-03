package com.example.binusezyfoody.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.binusezyfoody.MyOrderActivity;
import com.example.binusezyfoody.R;
import com.example.binusezyfoody.model.Drink;
import com.example.binusezyfoody.model.Order;
import com.example.binusezyfoody.storage.OrderStorage;

import java.util.ArrayList;
import java.util.List;

public class MyOrderAdapter extends ArrayAdapter<Order> {

    private Context context;
    private ArrayList<Order> orderArrayList;
    private static LayoutInflater inflater = null;


    public MyOrderAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Order> objects) {
        super(context, resource, objects);
        try {
            this.context = context;
            this.orderArrayList = objects;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {

        }
    }

    public int getCount() {
        return orderArrayList.size();
    }

    public Order getItem(Order position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView orderName;
        public TextView orderPrice;
        public Button hapusBtn;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;

        try {
            if (convertView == null) {
                view = inflater.inflate(R.layout.item_order, null);
                holder = new ViewHolder();
                holder.orderName = (TextView) view.findViewById(R.id.orderName);
                holder.orderPrice = (TextView) view.findViewById(R.id.orderPrice);
                holder.hapusBtn = (Button) view.findViewById(R.id.btnHapus);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.orderName.setText(orderArrayList.get(position).getDrink().getName());
            holder.orderPrice.setText(orderArrayList.get(position).getQuantity() + " x Rp. " + orderArrayList.get(position).getDrink().getPrice());
            holder.hapusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderStorage.getInstance().remove(orderArrayList.get(position));
                    orderArrayList.remove(orderArrayList.get(position));
                    notifyDataSetChanged();
                    Intent intent = new Intent(context.getApplicationContext(), MyOrderActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            });
        } catch (Exception e) {
        }
        return view;
    }

}

package com.example.binusezyfoody.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.model.Drink;

import java.util.ArrayList;

public class DrinkAdapter extends ArrayAdapter<Drink> {

    private Context context;
    private ArrayList<Drink> drinkArrayList;
    private static LayoutInflater inflater = null;

    public DrinkAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Drink> objects) {
        super(context, resource, objects);

        try {
            this.context = context;
            this.drinkArrayList = objects;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e){
        }
    }

    public int getCount() {
        return drinkArrayList.size();
    }

    public Drink getItem(Drink position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        public TextView drinkName;
        public TextView drinkPrice;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;
        try {
            if(convertView == null) {
                view = inflater.inflate(R.layout.item_drink, null);
                holder = new ViewHolder();
                holder.drinkName = (TextView) view.findViewById(R.id.drinkName);
                holder.drinkPrice = (TextView) view.findViewById(R.id.drinkPrice);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.drinkName.setText(drinkArrayList.get(position).getName());
            int price = drinkArrayList.get(position).getPrice();
            String priceDrink = Integer.toString(price);
            holder.drinkPrice.setText("Rp. " + priceDrink);
        } catch (Exception e) {
        }
        return  view;
    }
}

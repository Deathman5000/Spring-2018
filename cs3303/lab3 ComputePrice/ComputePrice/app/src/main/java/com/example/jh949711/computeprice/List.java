package com.example.jh949711.computeprice;
/*
This class holds the list of the items add after the list button is pushed
 */
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jh949711 on 2/21/18.
 */

public class List extends AppCompatActivity {
    String name, price, quantity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        TableLayout table = findViewById(R.id.TableLayout);
        Bundle b = this.getIntent().getExtras();
        ArrayList<String> nameArray = b.getStringArrayList("nameArray");
        ArrayList<String> priceArray = b.getStringArrayList("priceArray");
        ArrayList<String> quantityArray = b.getStringArrayList("quantityArray");
        for (int i = 0; i < nameArray.size(); i++) {
            TableRow row = new TableRow(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            name = nameArray.get(i);
            price = priceArray.get(i);
            quantity = quantityArray.get(i);
            double priceNum = Double.parseDouble(price);
            double quantityNum = Double.parseDouble(quantity);
            tv1.setText(name);
            tv2.setText(String.format("$%,.2f",priceNum));
            tv3.setText(String.format("%.2f", quantityNum));

            tv1.setPadding(20,0,30,0);
            tv2.setPadding(0,0,20,0);
            tv3.setPadding(0,0,2,0);
            tv1.setTypeface(Typeface.DEFAULT_BOLD);
            tv2.setTypeface(Typeface.DEFAULT_BOLD);
            tv3.setTypeface(Typeface.DEFAULT_BOLD);
            row.addView(tv1);
            row.addView(tv2);
            row.addView(tv3);
            table.addView(row);
        }
       /* Bundle c = new Bundle();
        c.putStringArrayList("ListNameArray",nameArray);
        c.putStringArrayList("ListPriceArray",priceArray);
        c.putStringArrayList("ListQuantityArray",quantityArray);
        Intent mainscreen = new Intent(List.this,ComputeActivity2.class);
        mainscreen.putExtras(c);
        startActivity(mainscreen);*/

    }


}

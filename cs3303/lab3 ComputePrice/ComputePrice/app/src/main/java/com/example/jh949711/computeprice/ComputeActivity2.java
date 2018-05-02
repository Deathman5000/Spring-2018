package com.example.jh949711.computeprice;
/*
This is the class that handles after we click compute.
This one will have the add and the list buttons active.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ComputeActivity2 extends AppCompatActivity {

    EditText n, tp, pr, q, t;
    String name, price, quantity, tax, totalPrice, Name, Price, Quanitity;
    Button add, list;
    int count = 0;
    Bundle BundleArray = new Bundle();

    static ArrayList<String> nameArray = new ArrayList<String>();
    static ArrayList<String> priceArray = new ArrayList<String>();
    static ArrayList<String> quantityArray = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        n = findViewById(R.id.name);
        pr = findViewById(R.id.price);
        q = findViewById(R.id.quantity);
        t = findViewById(R.id.tax);
        tp = findViewById(R.id.totalPrice);
        add = findViewById(R.id.addButton);
        list = findViewById(R.id.listButton);
        Bundle test = getIntent().getExtras();
        count = test.getInt("Count");

        if (count == 0) {
            Bundle extras = getIntent().getExtras();
            name = extras.getString("name");
            price = extras.getString("price");
            quantity = extras.getString("quantity");
            tax = extras.getString("tax");
            totalPrice = extras.getString("totalPrice");
            count = extras.getInt("Count");

            double priceNum = Double.parseDouble(price);
            double result = Double.parseDouble(totalPrice);
            double quantityNum = Double.parseDouble(quantity);
            double taxNum = Double.parseDouble(tax);

            n.setText(name);
            tp.setText(String.format("$%,.2f", result));
            pr.setText(String.format("$%,.2f", priceNum));
            q.setText(String.format("%.0f", quantityNum));
            t.setText(String.format("%5.2f", taxNum));

            nameArray.add(name);
            priceArray.add(price);
            quantityArray.add(quantity);
            BundleArray.putStringArrayList("nameArray",nameArray);
            BundleArray.putStringArrayList("priceArray",priceArray);
            BundleArray.putStringArrayList("quantityArray",quantityArray);
        }

        if (count > 0) {
            Bundle extras2 = getIntent().getExtras();
            name = extras2.getString("Name");
            price = extras2.getString("Price");
            quantity = extras2.getString("Quantity");
            tax = extras2.getString("addTax");
            totalPrice = extras2.getString("addTotal");

            double priceNum = Double.parseDouble(price);
            double quantityNum = Double.parseDouble(quantity);
            double taxNum = Double.parseDouble(tax);
            double toAdd = Double.parseDouble(totalPrice);

            double result = (priceNum*quantityNum) + (priceNum*quantityNum*taxNum)/100;
            double grandTotal = toAdd + result;

            n.setText(name);
            tp.setText(String.format("$%,.2f", grandTotal));
            pr.setText(String.format("$%,.2f", priceNum));
            q.setText(String.format("%.0f", quantityNum));
            t.setText(String.format("%5.2f", taxNum));

            nameArray.add(name);
            priceArray.add(price);
            quantityArray.add(quantity);
            BundleArray.putStringArrayList("nameArray",nameArray);
            BundleArray.putStringArrayList("priceArray",priceArray);
            BundleArray.putStringArrayList("quantityArray",quantityArray);

        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addScreen = new Intent(ComputeActivity2.this,AddActivity.class);
                count++;
                addScreen.putExtra("count",count);
                addScreen.putExtra("addTax",tax);
                addScreen.putExtra("addTotal",totalPrice);
                startActivity(addScreen);

            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listScreen = new Intent(ComputeActivity2.this, List.class);
                listScreen.putExtras(BundleArray);
                startActivity(listScreen);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
package com.example.jh949711.mystore;
/*
    This app shows a menu of breakfast items for purchase.
    If the button is clicked the user is prompted in another
    screen on the quantity that is wanted. After the user is
    done they can push process order and a table will show
    how much each item cost, a subtotal, and a grand total.
    Authors: Kyra Belanger, James Hund
    Version: 04/10/18
    Work distribution:
                      Kyra: activity_store.xml, StoreActivity.java, CreateTable.java
                      James: create_table.xml, table.xml, CreateTable.java, TableValues.java
                      We both worked evenly on all of the files
   Grade Deserved:    Kyra: 100%
                      James: 100%
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StoreActivity extends AppCompatActivity {

    ImageButton dasani, oatmeal, hotcakes, sausageBiscuit, baconEggBiscuit,
            eggSausageBiscuit, sausageBurrito;
    Button process;
    int arrayCount, itemCount = 0;
    public static String[] products;
    public static Double[] value;
    public static String[] nameArray = new String[7];
    public static int [] quantityArray = new int[7];
    public static double[] totalArray = new double[7];

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                nameArray = data.getExtras().getStringArray("nameArray").clone();
                quantityArray = data.getExtras().getIntArray("quantityArray").clone();
                totalArray = data.getExtras().getDoubleArray("totalArray").clone();
                itemCount++;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        //dcount = ocount = hcount = scount = bcount = ecount = sbcount = 0;
        arrayCount = 0;
        products = new String[]{"Dasani Water ", "Fruit Maple Oatmeal ", "Hotcakes ",
                "Sausage Biscuit ", "Bacon Egg Biscuit ", "Egg Sausage Biscuit ",
                "Sausage Burrito "};
        value = new Double[]{2.00, 2.00, 2.00, 1.99, 2.00, 2.00, 1.75};

        dasani = findViewById(R.id.DasaniButton);
        oatmeal = findViewById(R.id.FruitButton);
        hotcakes = findViewById(R.id.HotcakeButton);
        sausageBiscuit = findViewById(R.id.SausageBiscuitButton);
        baconEggBiscuit = findViewById(R.id.BaconBiscuitButton);
        eggSausageBiscuit = findViewById(R.id.EggSausageButton);
        sausageBurrito = findViewById(R.id.SausageBurritoButton);
        process = findViewById(R.id.ProcessButton);

        dasani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 0;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        oatmeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 1;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        hotcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 2;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        sausageBiscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 3;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        baconEggBiscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 4;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        eggSausageBiscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 5;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        sausageBurrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCount = 6;
                String stProducts = products[arrayCount];
                double price = value[arrayCount];
                Intent intent=new Intent(getApplicationContext(), CreateTable.class);
                intent.putExtra("name", stProducts);
                intent.putExtra("itemPrice", price);
                intent.putExtra("arrayCount", arrayCount);
                intent.putExtra("itemCount", itemCount);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                startActivityForResult(intent,1);
            }
        });

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TableValues.class);
                intent.putExtra("nameArray", nameArray);
                intent.putExtra("quantityArray", quantityArray);
                intent.putExtra("totalArray", totalArray);
                intent.putExtra("itemCount", itemCount);
                startActivity(intent);

            }
        });
    }


}
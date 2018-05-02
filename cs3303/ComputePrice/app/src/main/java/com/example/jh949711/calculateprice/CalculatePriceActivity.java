/*
    Author: James Hund
    Version: 02/05/2018
    Description: This app takes input from the user in forms of
                 price, quantity, and tax rate. It then gives the
                 total price for an item or items at the click of
                 a button.
 */
package com.example.jh949711.calculateprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatePriceActivity extends AppCompatActivity {

    EditText price, quantity, tax, totalPrice;
    Button compute, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_price);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        tax = findViewById(R.id.tax);
        totalPrice = findViewById(R.id.totalPrice);
        compute = findViewById(R.id.computeButton);
        reset = findViewById(R.id.resetButton);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(price.getText().toString().equals("")){
                    Toast.makeText(CalculatePriceActivity.this, "No Price entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if(quantity.getText().toString().equals("")){
                    Toast.makeText(CalculatePriceActivity.this, "No Quantity entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if(tax.getText().toString().equals("")){
                    Toast.makeText(CalculatePriceActivity.this, "No Tax entered",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    double pr = Double.parseDouble(price.getText().toString());
                    double q = Double.parseDouble(quantity.getText().toString());
                    double t = Double.parseDouble(tax.getText().toString());
                    double result = (pr*q) + (pr*q*t)/100;
                    totalPrice.setText(String.format("$%,.2f", result));
                    price.setText(String.format("$%,.2f", pr));
                    quantity.setText(String.format("%.0f", q));
                    tax.setText(String.format("%5.2f", t));
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText("");
                quantity.setText("");
                tax.setText("");
                totalPrice.setText("");
            }
        });
    }
}

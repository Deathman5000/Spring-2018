/*
    App: Compute Price
    Authors: Kyra Belanger, James Hund
    Version: 02/21/18
    Description: This program takes input from the user and computes the total price
                 of the items entered.
    Code:   Kyra Belanger: AddActivity.java, activity_list.xml, and we both contributed
                            to the compute activities.
            James Hund: List.java, activity_list.xml, and we both contributed to both
                        compute activities;
    Percentage Done: We both did our halves of the workload so Kyra 50% + James 50% = Total 100%

 */
package com.example.jh949711.computeprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ComputeActivity extends AppCompatActivity {

    EditText name, price, quantity, tax, totalPrice;
    Button compute;
    final int MY_REQUEST_CODE = 1;

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                name = data.getExtras().getInt("name");
                price = data.getExtras().getInt("price");
                quantity = data.getExtras().getInt("quantity");
                tax = data.getExtras().getInt("tax");
                totalPrice = data.getExtras().getInt("totalPrice");
            }
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        tax = findViewById(R.id.tax);
        totalPrice = findViewById(R.id.totalPrice);
        compute = findViewById(R.id.computeButton);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Name entered",
                            Toast.LENGTH_SHORT).show();
                }
                if(price.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Price entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if(quantity.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Quantity entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if(tax.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Tax entered",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    String n = name.getText().toString();
                    double pr = Double.parseDouble(price.getText().toString());
                    double q = Double.parseDouble(quantity.getText().toString());
                    double t = Double.parseDouble(tax.getText().toString());
                    double result = (pr*q) + (pr*q*t)/100;

                    name.setText(n);
                    totalPrice.setText(String.format("$%,.2f", result));
                    price.setText(String.format("$%,.2f", pr));
                    quantity.setText(String.format("%.0f", q));
                    tax.setText(String.format("%5.2f", t));

                    String stringPrice = Double.toString(pr);
                    String stringQuantity = Double.toString(q);
                    String stringTax = Double.toString(t);
                    String stringResult = Double.toString(result);
                    /*ArrayList<String> nameArray = new ArrayList<String>();
                    ArrayList<String> priceArray = new ArrayList<String>();
                    ArrayList<String> quantityArray = new ArrayList<String>();
                    nameArray.add(n);
                    priceArray.add(stringPrice);
                    quantityArray.add(stringQuantity);
                    Bundle b = new Bundle();
                    b.putStringArrayList("nameArray",nameArray);
                    b.putStringArrayList("priceArray",priceArray);
                    b.putStringArrayList("quantityArray",quantityArray);
                    Intent i = new Intent(ComputeActivity.this, ComputeActivity2.class);
                    i.putExtras(b);*/


                    Intent intent = new Intent(ComputeActivity.this, ComputeActivity2.class);
                    //intent.putExtra("from", "ComputeActivity");
                    intent.putExtra("name",n);
                    intent.putExtra("totalPrice",stringResult);
                    intent.putExtra("price",stringPrice);
                    intent.putExtra("quantity",stringQuantity);
                    intent.putExtra("tax",stringTax);
                    startActivity(intent);
                }
            }
        });
    }
}

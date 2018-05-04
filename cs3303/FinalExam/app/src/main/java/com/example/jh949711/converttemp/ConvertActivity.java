package com.example.jh949711.converttemp;
/*
    Description: This app will convert from Celsius to Fahrenheit and vice versa.
    Author: James Hund
    Version: 05/04/18
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConvertActivity extends AppCompatActivity {

    EditText Fahrenheit, Celsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        Fahrenheit = findViewById(R.id.fahrenheit);
        Celsius = findViewById(R.id.celsius);
    }

    public void To_C(View view) {
        if (Fahrenheit.getText().toString().equals("")){
            Toast.makeText(this,"No temperature entered",Toast.LENGTH_SHORT).show();
        }
        else{
            double c = Double.parseDouble(Fahrenheit.getText().toString());
            double result = (c-32.0) *(5.0/9.0);
            Celsius.setText(String.format("%,.2f", result));
        }
    }

    public void To_F(View view) {
        if (Celsius.getText().toString().equals("")){
            Toast.makeText(this,"No temperature entered",Toast.LENGTH_SHORT).show();
        }
        else{
            double f = Double.parseDouble(Celsius.getText().toString());
            double result = f*(9.0/5.0)+32.0;
            Fahrenheit.setText(String.format("%,.2f", result));
        }
    }

    public void reset(View view) {
        Fahrenheit.setText("");
        Celsius.setText("");
        Celsius.requestFocus();
    }
}

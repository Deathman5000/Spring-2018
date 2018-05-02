package com.example.jh949711.phonebook;
/*
    This app sets up the contact list for the phone call application. The user is able to add and
    delete contacts.
    Authors: Kyra Belanger, James Hund
    Version: 04/21/18
    Parts worked on: Kyra: Both xml files and the DisplayActivity
                     James: PhoneBookActivity.java, MyContentProvider.java, Product.java
    Grade deserved: Kyra:  100%
                    James: 100%
 */

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneBookActivity extends AppCompatActivity {

    EditText firstName, lastName, phoneNumber;
    Button addButton, deleteButton, showAllButton, clearFieldButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);
        addButton = findViewById(R.id.add);
        deleteButton = findViewById(R.id.delete);
        showAllButton = findViewById(R.id.showAll);
        clearFieldButton = findViewById(R.id.clearField);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstName.getText().toString() == "" || lastName.getText().toString() == "" || phoneNumber.getText().toString() == ""){
                    Toast.makeText(PhoneBookActivity.this,"Please enter all parameters", Toast.LENGTH_SHORT).show();
                }
                else {
                    Product product = new Product(firstName.getText().toString(),
                            lastName.getText().toString(), (phoneNumber.getText().toString()).substring(0, 3) + "-" +
                            (phoneNumber.getText().toString()).substring(3, 6) + "-" + (phoneNumber.getText().toString()).substring(6, 10));
                    ContentValues values = new ContentValues();
                    values.put(MyContentProvider.COLUMN_FIRST_NAME, product.getFirstName());
                    values.put(MyContentProvider.COLUMN_LAST_NAME, product.getLastName());
                    values.put(MyContentProvider.COLUMN_PHONE_NUMBER, product.getPNumber());
                    Uri uri = getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
                    Toast.makeText(PhoneBookActivity.this, "New product " + product.getFirstName() + " " +
                            product.getLastName() + " " + product.getPNumber() + " added", Toast.LENGTH_SHORT).show();

                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "firstName = \"" + firstName.getText().toString() + "\" AND lastName = \""
                        + lastName.getText().toString() + "\"";
                int result =
                        getContentResolver().delete(MyContentProvider.CONTENT_URI,selection,null);
                if(result > 0){
                    Toast.makeText(PhoneBookActivity.this,firstName.getText().toString() + " " +
                            lastName.getText().toString() +  " was deleted from contacts.", Toast.LENGTH_SHORT).show();
                    firstName.setText("");
                    lastName.setText("");
                    phoneNumber.setText("");
                    firstName.requestFocus();

                }
                else
                    Toast.makeText(PhoneBookActivity.this,"No match found", Toast.LENGTH_SHORT).show();
            }
        });

        clearFieldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText("");
                lastName.setText("");
                phoneNumber.setText("");
                firstName.requestFocus();
            }
        });
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText("");
                lastName.setText("");
                phoneNumber.setText("");
                firstName.requestFocus();
                Intent intent = new Intent(PhoneBookActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }


}

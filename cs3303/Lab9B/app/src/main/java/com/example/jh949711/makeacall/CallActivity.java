package com.example.jh949711.makeacall;
/*
    This app takes the info from the PhoneBook app and the user can make a call or look up the contact.
    Authors: Kyra Belanger, James Hund
    Version: 04/21/18
    Parts worked on: We both equally worked on both files in this app.
    Grade deserved: Kyra:  100%
                    James: 100%
 */

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "firstName";
    private static final String COLUMN_LAST_NAME = "lastName";
    private static final String COLUMN_PHONE_NUMBER = "number";
    EditText fName, lName;
    Button find, call;
    String firstName, lastName;
    static String [] arrayFName, arrayLName, arrayPhone;
    int index;
    boolean found;
    static String f, l, s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        fName = findViewById(R.id.firstName);
        lName = findViewById(R.id.lastName);
        find = findViewById(R.id.find);
        call = findViewById(R.id.makeCall);
        found = false;

        String AUTHORITY = "com.example.jh949711.phonebook.MyContentProvider";
        String TABLE_PRODUCT = "product";
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" +TABLE_PRODUCT);
        ContentResolver contentResolver = getContentResolver();
        String [] projection = {COLUMN_ID, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_PHONE_NUMBER};
        Cursor cursor = contentResolver.query(CONTENT_URI,projection,null,null,null);
        s = "";
        f = "";
        l = "";

        if (!cursor.moveToFirst()) {s = "no result to display";}
        else{
            do {
                f += String.format("%s\n", cursor.getString(1));
                l += String.format("%s\n", cursor.getString(2));
                s += String.format("%-10s\n", cursor.getString(3));

            } while (cursor.moveToNext());
        }

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = findViewById(R.id.phoneNumber);
                arrayFName = f.split("\n");
                arrayLName = l.split("\n");
                arrayPhone = s.split("\n");

                firstName = fName.getText().toString();
                lastName = lName.getText().toString();
                
                for ( int j = 0; j < arrayFName.length; j++ ) {
                    if ( (firstName.equals(arrayFName[j])) && (lastName.equals(arrayLName[j])) ) {
                        tv.setText(arrayPhone[j]);
                        index = j;
                        found = true;
                        break;
                    }
                    else {
                        tv.setText("Name was not found. Check spelling");
                    }
                }

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AUTHORITY = "com.example.jh949711.phonebook.MyContentProvider";
                String TABLE_PRODUCT = "product";
                Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" +TABLE_PRODUCT);
                ContentResolver contentResolver = getContentResolver();
                String [] projection = {COLUMN_ID, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_PHONE_NUMBER};
                Cursor cursor = contentResolver.query(CONTENT_URI,projection,null,null,null);
                String s = "";
                if (!found) {
                    Toast.makeText(CallActivity.this , "Name not in contacts",
                            Toast.LENGTH_SHORT).show();
                }

                else{
                    String phone_number = arrayPhone[index];
                    try {
                        Uri uri = Uri.parse("tel:" + phone_number);
                        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                        Log.i("Phone Call App", phone_number);
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "Application failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}

package com.example.jh949711.phonebook;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Kyra on 4/20/18.
 */

public class DisplayActivity extends AppCompatActivity{

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String [] projection = {MyContentProvider.COLUMN_ID,
                MyContentProvider.COLUMN_FIRST_NAME,
                MyContentProvider.COLUMN_LAST_NAME,
                MyContentProvider.COLUMN_PHONE_NUMBER};
        Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI,
                projection,null,null);
        int count = cursor.getCount();
        cursor.moveToFirst();
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setVerticalScrollBarEnabled(true);
        TableRow row = new TableRow(this);
        TextView t0,t1,t2;
        t0 = new TextView(this);
        t0.setText("FirstName");
        t0.setTextColor(Color.RED);
        t0.setTypeface(null, Typeface.BOLD);
        t0.setPadding(20,20,20,20);
        row.addView(t0);
        t1 = new TextView(this);
        t1.setText("LastName");
        t1.setTextColor(Color.RED);
        t1.setTypeface(null, Typeface.BOLD);
        t1.setPadding(20,20,20,20);
        row.addView(t1);
        t2 = new TextView(this);
        t2.setText("Phone Number");
        t2.setTextColor(Color.RED);
        t2.setTypeface(null, Typeface.BOLD);
        t2.setPadding(20,20,20,20);
        row.addView(t2);
        tableLayout.addView(row);
        for(int i = 0; i < count; i++){
            row = new TableRow(this);
            t0 = new TextView(this);
            t0.setText(""+cursor.getString(1));
            t0.setTextColor(Color.BLACK);
            t0.setPadding(20,20,20,20);
            row.addView(t0);
            t1 = new TextView(this);
            t1.setText(cursor.getString(2));
            t1.setTextColor(Color.BLACK);
            t1.setPadding(20,20,20,20);
            row.addView(t1);
            t2 = new TextView(this);
            t2.setText(""+cursor.getString(3));
            t2.setPadding(20,20,20,20);
            row.addView(t2);
            tableLayout.addView(row);
            cursor.moveToNext();
        }
        setContentView(tableLayout);
    }

}


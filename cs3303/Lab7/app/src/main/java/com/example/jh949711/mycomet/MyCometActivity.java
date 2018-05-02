package com.example.jh949711.mycomet;
/*
    This app makes a "comet" go around in an elliptic path around the screen.
    Author: James Hund
    Version: 04/03/18
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class MyCometActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comet);
        //to find the width and height of the ui screen
        //DisplayMatrix instance is used to get general information
        //about screen size and so on.
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //next create an instance of window manager to communicate with it
        WindowManager windowManager =
                (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        // tell this window manager to create a new window for drawing or objects
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float width = displayMetrics.widthPixels;
        float height = displayMetrics.heightPixels;
        setContentView(new CometAnimation (this,width,height));
    }
}

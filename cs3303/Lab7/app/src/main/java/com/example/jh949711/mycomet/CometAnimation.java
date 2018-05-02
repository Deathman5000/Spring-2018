package com.example.jh949711.mycomet;
/*
    This class is what controls the motion of the comet.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

public class CometAnimation extends View {

    private float cx, cy, radius, sHeight, sWidth;
    Context c;
    int i = 0;

    public CometAnimation(Context context, float w, float h){
        super(context);
        c = context;
        sWidth = w - 100;
        sHeight = h - 100;
        cx = sWidth/2;
        cy = sHeight/2;
        radius = 50;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(cx, cy, radius, paint);
        updateCoordinates();
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e){
            Toast.makeText(c, "Fatal error during the sleep interval", Toast.LENGTH_SHORT).show();
        }
        //invalidate whole view and invoke the callback onDraw()
        invalidate();
    }


    private void updateCoordinates(){
        float copyx = sWidth/2;
        float copyy = sHeight/2;
        if (i<=360){
            double holderx = (copyx-100)*Math.cos(Math.toRadians(i))+700;
            double holdery = (copyy-200)*Math.sin(Math.toRadians(i))+1050;
            cx = (float)holderx;
            cy = (float)holdery;
            i++;
        }
        if (i>360) i=0;
    }
}

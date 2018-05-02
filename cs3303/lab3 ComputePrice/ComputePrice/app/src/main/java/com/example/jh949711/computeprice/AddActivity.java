package com.example.jh949711.computeprice;
/*
This class is what happens after the add button is pushed.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jh949711 on 2/21/18.
 */

public class AddActivity extends AppCompatActivity {

        EditText aname, aprice, aquantity;
        TextView countTV;
        int count = 0;
        String tax, totalPrice;
    ArrayList<String> nameArray = new ArrayList<String>(100);
    ArrayList<String> priceArray = new ArrayList<String>(100);
    ArrayList<String> quantityArray = new ArrayList<String>(100);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);
            Bundle c = getIntent().getExtras();
            nameArray = c.getStringArrayList("nameArray");
            priceArray = c.getStringArrayList("priceArray");
            quantityArray = c.getStringArrayList("quantityArray");
            totalPrice = c.getString("addTotal");
            tax = c.getString("addTax");
            count = c.getInt("count");
            countTV = findViewById(R.id.countID);
            countTV.setText("Number of Items: " + count);
        /*    aname = findViewById(R.id.addName);
            aprice = findViewById(R.id.addPrice);
            aquantity = findViewById(R.id.addQuantity);

            String n = aname.getText().toString();
            double pr = Double.parseDouble(aprice.getText().toString());
            double q = Double.parseDouble(aquantity.getText().toString());

            String sPrice = Double.toString(pr);
            String sQuantity = Double.toString(q);

            Intent intent1 = new Intent(AddActivity.this, ComputeActivity2.class );
            //intent1.putExtra("from", "AddActivity");
            intent1.putExtra("Name", n);
            intent1.putExtra("Price", sPrice);
            intent1.putExtra("Quantity", sQuantity);

            startActivity(intent1);*/

        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();

            aname = findViewById(R.id.addName);
            aprice = findViewById(R.id.addPrice);
            aquantity = findViewById(R.id.addQuantity);

            String n = aname.getText().toString();
            double pr = Double.parseDouble(aprice.getText().toString());
            int q = Integer.parseInt(aquantity.getText().toString());
            /*aname.setText(n);
            aprice.setText(String.format("$%,.2f", pr));
            aquantity.setText(String.format("%.0f", q));*/

            String sPrice = Double.toString(pr);
            String sQuantity = Integer.toString(q);
       /*     nameArray.add(n);
            //nameArray.add(Name);
            priceArray.add(sPrice);
            //priceArray.add(Price);
            quantityArray.add(sQuantity);
            //quantityArray.add(Quanitity);
            Bundle c = new Bundle();
            c.putStringArrayList("ListNameArray",nameArray);
            c.putStringArrayList("ListPriceArray",priceArray);
            c.putStringArrayList("ListQuantityArray",quantityArray);*/
            Intent intent1 = new Intent(AddActivity.this, ComputeActivity2.class );
                //intent1.putExtra("from", "AddActivity");
                intent1.putExtra("Name", n);
                intent1.putExtra("Price", sPrice);
                intent1.putExtra("Quantity", sQuantity);
                intent1.putExtra("Count",count);
                intent1.putExtra("addTax",tax);
                intent1.putExtra("addTotal",totalPrice);
              //  intent1.putExtras(c);


            startActivity( intent1 );
            finish();
        }
}

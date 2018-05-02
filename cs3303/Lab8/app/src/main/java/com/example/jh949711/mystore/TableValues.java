package com.example.jh949711.mystore;

/*
    This class builds the table for the ending of the application
 */
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableValues extends AppCompatActivity {

    String name,stQuantity;
    String [] nameArray = new String[7];
    int [] quantityArray = new int[7];
    double [] totalArray = new double[7];
    int itemCount;
    double tax, total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        TableLayout table = findViewById(R.id.table);
        Bundle b = this.getIntent().getExtras();
        nameArray = b.getStringArray("nameArray").clone();
        quantityArray = b.getIntArray("quantityArray").clone();
        totalArray = b.getDoubleArray("totalArray").clone();
        itemCount = b.getInt("itemCount");

        for (int i = 0; i <= 6;i++){
            TableRow rows = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);

            if (nameArray[i] != null) {
                c1.setText(nameArray[i]);
                c2.setText(String.format("%1d", quantityArray[i]));
                c3.setText(String.format("$%,.2f", totalArray[i]));

                c1.setPadding(10, 0, 20, 0);
                c2.setPadding(20, 0, 20, 0);
                c3.setPadding(20, 0, 20, 0);

                c1.setTypeface(Typeface.DEFAULT_BOLD);
                c2.setTypeface(Typeface.DEFAULT_BOLD);
                c3.setTypeface(Typeface.DEFAULT_BOLD);

                rows.addView(c1);
                rows.addView(c2);
                rows.addView(c3);
                total = total + totalArray[i];

                table.addView(rows);
            }
            if (i == 6) {
                for (int j = 1; j <= 3; j++) {
                    TableRow row2 = new TableRow(this);
                    TextView c4 = new TextView(this);
                    TextView c5 = new TextView(this);
                    TextView space = new TextView(this);
                    if (j == 1) {
                        c4.setText("Sub Total");
                        c5.setText(String.format("$%,.2f", total));


                    } else if (j == 2) {
                        c4.setText("Tax (8.25%)");
                        tax = total * .0825;
                        c5.setText(String.format("$%,.2f", tax));

                    } else if (j == 3) {
                        c4.setText("Total");
                        total = total + tax;
                        c5.setText(String.format("$%,.2f", total));
                    }

                    space.setText("       ");

                    c4.setPadding(10, 0, 20, 0);
                    space.setPadding(20, 0, 20, 0);
                    c5.setPadding(20, 0, 20, 0);

                    c4.setTypeface(Typeface.DEFAULT_BOLD);
                    c5.setTypeface(Typeface.DEFAULT_BOLD);

                    row2.addView(c4);
                    row2.addView(space);
                    row2.addView(c5);

                    table.addView(row2);
                }

            }
        }

    }
}
package com.example.jh949711.todolist;
/*
    This app will make a list of items taken from the user. The user has the option to add, delete,
    and show items in the list.
    Author: James Hund
    Version: 04/18/18
 */

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    EditText itemName;
    Button addButton, deleteButton, showAllButton;
    TableLayout table;
    ArrayList ItemList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        itemName = findViewById(R.id.itemName);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        showAllButton = findViewById(R.id.showButton);
        table = findViewById(R.id.table);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemName.getText().toString() == ""){
                    Toast.makeText(ToDoListActivity.this, "No Item entered",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    String item = itemName.getText().toString();
                    ItemList.add(item);
                    Toast.makeText(ToDoListActivity.this, "Item was added", Toast.LENGTH_SHORT).show();
                    itemName.setText("");
                    itemName.setText("");
                    table.removeAllViews();
                    int size = ItemList.size();
                    for (int index = 0;index<=size-1;index++){
                        TableRow row = new TableRow(ToDoListActivity.this);
                        TextView tv1 = new TextView(ToDoListActivity.this);
                        tv1.setText("");
                        tv1.setPadding(20,0,30,0);
                        tv1.setTypeface(Typeface.DEFAULT_BOLD);
                        row.addView(tv1);
                        table.addView(row);
                    }

                }
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemName.getText().toString() == ""){
                    Toast.makeText(ToDoListActivity.this, "No Item entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if (ItemList.contains(itemName.getText().toString())){
                    ItemList.remove(itemName.getText().toString());
                    Toast.makeText(ToDoListActivity.this, "Item was deleted", Toast.LENGTH_SHORT).show();
                    itemName.setText("");
                    table.removeAllViews();
                    int size = ItemList.size();
                    for (int index = 0;index<=size-1;index++){
                        TableRow row = new TableRow(ToDoListActivity.this);
                        TextView tv1 = new TextView(ToDoListActivity.this);
                        tv1.setText("");
                        tv1.setPadding(20,0,30,0);
                        tv1.setTypeface(Typeface.DEFAULT_BOLD);
                        row.addView(tv1);
                        table.addView(row);
                    }
                }
                else{
                    Toast.makeText(ToDoListActivity.this, "Item does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table.removeAllViews();
                int size = ItemList.size();
                if (size == 0){
                    Toast.makeText(ToDoListActivity.this,"List is empty",Toast.LENGTH_SHORT).show();;
                }
                for (int index = 0;index<=size-1;index++){
                    TableRow row = new TableRow(ToDoListActivity.this);
                    TextView tv1 = new TextView(ToDoListActivity.this);
                    tv1.setText(ItemList.get(index).toString());
                    tv1.setPadding(20,0,30,0);
                    tv1.setTypeface(Typeface.DEFAULT_BOLD);
                    row.addView(tv1);
                    table.addView(row);
                }
            }
        });
    }
}

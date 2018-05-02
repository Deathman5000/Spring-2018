/*
  Project Name: Lab1App
  Author: James Hund
  Date: 1/29/18
  Description: This app will go through a series of questions and ask if it is true or false.
               It will go in a loop so that it won't run off the end of the array.
 */
package com.example.jh949711.geoquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GeoQuizActivity extends AppCompatActivity {

    TextView question_label;
    Button no, yes, next, previous;
    Question [] questionBank;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_quiz);
        questionBank = new Question[5];
        questionBank[0] = new Question();
        questionBank[0].setStatement("Mexico City is the capital of Mexico");
        questionBank[0].setAnswer(true);
        questionBank[1] = new Question();
        questionBank[1].setStatement("Toronto is the capital of Canada");
        questionBank[1].setAnswer(false);
        questionBank[2] = new Question();
        questionBank[2].setStatement("London is the capital of United Kingdom");
        questionBank[2].setAnswer(true);
        questionBank[3] = new Question();
        questionBank[3].setStatement("Milan is the capital of Italy");
        questionBank[3].setAnswer(false);
        questionBank[4] = new Question();
        questionBank[4].setStatement("Jerusalem is the capital of Israel");
        questionBank[4].setAnswer(true);
        question_label = findViewById(R.id.q_label);
        i = 0;
        question_label.setText(questionBank[i].getStatement());
        no = findViewById(R.id.false_button);
        yes = findViewById(R.id.true_button);
        next = findViewById(R.id.next_button);
        previous = findViewById(R.id.previous_button);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               verify(false);
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify(true);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i++;
                if(i > 4){
                    i = 0;
                }
                question_label.setText(questionBank[i].getStatement());
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i--;
                if(i < 0){
                    i = 4;
                }
                question_label.setText(questionBank[i].getStatement());
            }
        });
    }
    private void verify(boolean b){
        if(questionBank[i].getAnswer()==b){
            Toast.makeText(GeoQuizActivity.this,
                    "Correct answer", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(GeoQuizActivity.this,
                "Sorry your selection is incorrect", Toast.LENGTH_SHORT).show();
    }
}

package com.example.jh949711.cardvalidator;
/*
    Author: James Hund
    Version :02/26/18
    Description: This application takes in a number and validates whether it is
                 a valid credit card or not.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ValidateActivity extends AppCompatActivity {

    TextView number;
    Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);
        number = findViewById(R.id.cardNumber);
        validate = findViewById(R.id.validateButton);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number.getText().toString().equals("")){
                    Toast.makeText(ValidateActivity.this,"No Number Entered",
                            Toast.LENGTH_SHORT).show();

                }
              /*  else if (!number.getText().toString().substring(1).equals("3")||!number.getText()
                        .toString().substring(2).equals("4")||!number.getText()
                        .toString().substring(2).equals("7")){
                    Toast.makeText(ValidateActivity.this,"Must begin with 34 or 37",
                            Toast.LENGTH_SHORT).show();

                }*/
                else if (number.getText().toString().length()!=15){
                    Toast.makeText(ValidateActivity.this,"Number is not long enough",
                            Toast.LENGTH_SHORT).show();

                }

                else if (number.getText().toString().length()>=16){
                    Toast.makeText(ValidateActivity.this,"Number is to long",
                            Toast.LENGTH_SHORT).show();

                }
                else{
                    double cardNo = Double.parseDouble(number.getText().toString());
                    double remainder;
                    double temp = cardNo;
                    double result = 0;
                    double digit1, digit2, digit3, digit4, digit5, digit6, digit7,digit8,
                            digit9, digit10, digit11, digit12, digit13, digit14, digit0;
                    String input = Double.toString(temp);
                    String reversed = new StringBuffer(input).reverse().toString();
                    /*while (temp > 0) {
                        remainder = temp % 10;
                        temp = temp / 10;
                        result = (result * 10) + remainder;
                    }*/
                    //String x_str = Double.toString(result);
                    //double new_x = Double.parseDouble(x_str.substring(1));
                    temp = Double.parseDouble(reversed);

                    digit14 = temp % 10;
                    digit13 = digit14 % 10;
                    digit12 = digit13 % 10;
                    digit11 = digit12 % 10;
                    digit10 = digit11 % 10;
                    digit9 = digit10 % 10;
                    digit8 = digit9 % 10;
                    digit7 = digit8 % 10;
                    digit6 = digit7 % 10;
                    digit5 = digit6 % 10;
                    digit4 = digit5 % 10;
                    digit3 = digit4 % 10;
                    digit2 = digit3 % 10;
                    digit1 = digit2 % 10;
                    digit0 = digit1 % 10;

                    double sum = ((digit1*2)-9) + digit2 + ((digit3*2)-9) + digit4 + ((digit5*2)-9)
                            + digit6 + ((digit7*2)-9) + digit8 + ((digit9*2)-9) + digit10 +
                            ((digit11*2)-9) + digit12 + ((digit13*2)-9) + digit14;

                    double check = sum + digit0;
                    if(check % 10 == 0){
                        Toast.makeText(ValidateActivity.this,"Valid Number",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ValidateActivity.this,"Invalid Number",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

package com.example.jh949711.dowjonesaverage;
/*
    This app uses URLs to gather the data needed to compute the Dow Jones Industrial Average.
    It uses an array to hold the symbols to replace in the URL to go to the websites.
    It then grabs the previous close data and adds them together. It then will divide it by
    the DJIA constant to get the average. It gives updates on the progress via progress bar.
    At the end of the computation, it will display the average along with the time it took to
    compute the average in seconds.

    Author: James Hund
    Version: 03/27/18
    What I learned: In this program I learned how to access a URL and modify it to get the data I
    needed. I also learned how to further use the AsyncTask to accomplish this.
 */

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DowJonesAverageActivity extends AppCompatActivity {

    String [] company = new String[30];
    String [] url = new String[30];
    TextView result, change;
    Button compute;
    ProgressBar progressBar;
    int i;
    double beginning, end, timeTaken;
    double constant = 0.14523396877348;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dow_jones_average);
        result = (TextView)findViewById(R.id.result);
        change = (TextView)findViewById(R.id.textView);
        compute = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                company[0] = "AXP";
                company[1] = "AAPL";
                company[2] = "BA";
                company[3] = "CAT";
                company[4] = "CVX";
                company[5] = "CSCO";
                company[6] = "KO";
                company[7] = "DIS";
                company[8] = "DWDP";
                company[9] = "XOM";
                company[10] = "GE";
                company[11] = "GS";
                company[12] = "HD";
                company[13] = "IBM";
                company[14] = "INTC";
                company[15] = "JNJ";
                company[16] = "JPM";
                company[17] = "MCD";
                company[18] = "MRK";
                company[19] = "MMM";
                company[20] = "MSFT";
                company[21] = "NKE";
                company[22] = "PFE";
                company[23] = "PG";
                company[24] = "TRV";
                company[25] = "UTX";
                company[26] = "UNH";
                company[27] = "VZ";
                company[28] = "V";
                company[29] = "WMT";
                // a few arrays that will be used to access the url. It will be used to create another array

                    i = 0;
                    while (i <=29) {
                        String st = company[i];
                        st = "https://query1.finance.yahoo.com/v8/finance/chart/" + st + "?interval=2m";
                        url[i] = st;
                        i++;
                    }
                    i=0;
                    new FindPrice().execute(url);
            }
        });
    }
    private class FindPrice extends AsyncTask<String,Integer,String> {
        double total;

        @Override
        protected String doInBackground(String... params) {
            String priceString = "";
            int time = 0;
            try {
                for (i = 0; i <=29;i++) {
                    URL url = new URL(params[i]);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String line = bufferedReader.readLine();
                    String[] ar = line.split("\"previousClose\":");
                    String[] sr = ar[1].split(",");
                    priceString = sr[0];
                    Log.i("doInBackground", "Stock price " + priceString);
                    bufferedReader.close();
                    total = total + Double.parseDouble(priceString);
                    time++;
                    publishProgress(time);
                }
                total = total / constant;
                priceString = new Double(total).toString();
            }
            catch (MalformedURLException e){
                Toast.makeText(getApplicationContext(), "URL Error",Toast.LENGTH_SHORT).show();
            }
            catch (IOException e) {
                Toast.makeText(getApplicationContext(), "URL Error",Toast.LENGTH_SHORT).show();
            }
            return priceString;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          //  ticker = symbol.getText().toString();
            change.setText("DJIA computation in progress ...");
            beginning = System.nanoTime();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            end = System.nanoTime();
            timeTaken = (end-beginning)/1000000000;
            change.setText("DJIA for the previous day close is " + String.format( "%,.2f", total));
            result.setText("Time taken for the computation is "+ String.format("%,.2f", timeTaken) + " sec.");
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }
    }
}

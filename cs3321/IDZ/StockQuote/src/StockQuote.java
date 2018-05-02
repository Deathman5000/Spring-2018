/*
     This program shows how to use a url to pull data from it. In particular, it retrieves the
     the previous closing day stock price of Microsoft
     url: https://query1.finance.yahoo.com/v8/finance/chart/MSFT?interval=1m
     author: James Hund
     version: 01/31/2018
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StockQuote {

    public  static void main(String [] args){
        try {
            URL url = new URL("https://query1.finance.yahoo.com/v8/finance/chart/MSFT?interval=1m");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            //System.out.println(line);
            String [] ar = line.split("\"previousClose\":");
            String [] s1 = ar[1].split(",");
            System.out.println(s1[0]);
        }
        catch (MalformedURLException mle){
            mle.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

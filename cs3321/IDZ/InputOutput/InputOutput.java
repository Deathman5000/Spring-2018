/*
   This program shows how to read from a file and write to a file. 
   Input file: in1
   ***************************
   in1 content: 
   Hello
   50
   ***************************
   Output file: out1
   in1 must be saved in the same folder 
   out1 will be created if no file exists; otherwise rewrite existing out1
   ****************
   out1 content after the program runs:
   Hello
   51
   ***************
   author: James Hund
   version: 01/29/18
   file name: InputOutput.java
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class InputOutput {

    public static void main(String [] args){
        File inFile = new File ("in1");
        File outFile = new File ("out1");
        try {
            Scanner sc = new Scanner(inFile);
            FileWriter fWriter = new FileWriter (outFile);
            PrintWriter pWriter = new PrintWriter (fWriter);
            String line = sc.nextLine(); // read the first line
            pWriter.println (line); // write it back to out1
            line = sc.nextLine(); // read the next line
            int n = Integer.parseInt(line); // convert to int
            n++;  // increment input number
            pWriter.println (n);
            pWriter.close();
            sc.close();
        }
        catch (FileNotFoundException fnfe){  // need this for scanner exception
            fnfe.printStackTrace();
        }
        catch (IOException ioe){  // need this for FileWriter and PrintWriter exception
            ioe.printStackTrace();
        }
    }
}
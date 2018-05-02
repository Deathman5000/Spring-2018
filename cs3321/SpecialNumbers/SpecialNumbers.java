/*
    Program: SpecialNumbers.java
    Author: James Hund
    Version: 2-3-18
    Description: This program takes the numbers 100-1,000,000 and determines which numbers have their
                 interior numbers raised to the number of digits and then added together to equal the
                 original number. IE: 9,474 = 9^4+4^4+7^4+4^4
 */

import java.util.ArrayList;
import java.util.List;

public class SpecialNumbers {


    public static void main(String[] args) {
        int temp; //holds the number being calculated so that we can get the remainder
        int onePlace; // holds the one place for the number
        int tenPlace; //holds the tens place for the number
        int hundredPlace; //holds the onehundreds place for the number
        int thousandPlace; // holds the onethousands place for the number
        int TenthousandPlace; // holds the tenthousands place for the number
        int HundredThousandPlace; // holds the hundredthousands place for the number
        int result; //holds the number after calculations are made

        for (int i = 100; i <= 999; i++){
            temp = i / 10; //first calculation to get rid of the ones place
            onePlace = i % 10; // holds the one place integer
            tenPlace = temp % 10; // holds the tens place integer
            temp = temp / 10; // second calculation to get rid of the original tens place
            hundredPlace = temp % 10; //holds the hundreds place integer
            temp = temp / 10;
            onePlace = (int)Math.pow(onePlace, 3); // is the equivalent of onePlace**3
            tenPlace = (int)Math.pow(tenPlace, 3);
            hundredPlace = (int)Math.pow(hundredPlace, 3);
            result = onePlace + tenPlace + hundredPlace; // gets the result of the prievous calculations
            if (i == result){
                String numberAsString = String.format("%,d",i);
                System.out.println(numberAsString);
            }


        }

        /*
         * The rest of the paragraphs do the same as the first except that they add one more calculation
         * for each paragraph so it can get an extra digit.
         */
        for (int i = 1000; i <= 9999; i++) {
            temp = i / 10;
            onePlace = i % 10;
            tenPlace = temp % 10;
            temp = temp / 10;
            hundredPlace = temp % 10;
            temp = temp / 10;
            thousandPlace = temp % 10;
            temp = temp / 10;
            onePlace = (int)Math.pow(onePlace, 4);
            tenPlace = (int)Math.pow(tenPlace, 4);
            hundredPlace = (int)Math.pow(hundredPlace, 4);
            thousandPlace = (int)Math.pow(thousandPlace, 4);
            result = onePlace + tenPlace + hundredPlace + thousandPlace;
            if (i == result){
                String numberAsString = String.format("%,d",i);
                System.out.println(numberAsString);
            }
        }


        for (int i = 10000; i <= 99999; i++) {
            temp = i / 10;
            onePlace = i % 10;
            tenPlace = temp % 10;
            temp = temp / 10;
            hundredPlace = temp % 10;
            temp = temp / 10;
            thousandPlace = temp % 10;
            temp = temp / 10;
            TenthousandPlace = temp % 10;
            onePlace = (int)Math.pow(onePlace, 5);
            tenPlace = (int)Math.pow(tenPlace, 5);
            hundredPlace = (int)Math.pow(hundredPlace, 5);
            thousandPlace = (int)Math.pow(thousandPlace, 5);
            TenthousandPlace = (int)Math.pow(TenthousandPlace, 5);
            result = onePlace + tenPlace + hundredPlace + thousandPlace + TenthousandPlace;
            if (i == result){
                String numberAsString = String.format("%,d",i);
                System.out.println(numberAsString);
            }
        }


        for (int i = 100000; i <= 999999; i++) {
            temp = i / 10;
            onePlace = i % 10;
            tenPlace = temp % 10;
            temp = temp / 10;
            hundredPlace = temp % 10;
            temp = temp / 10;
            thousandPlace = temp % 10;
            temp = temp / 10;
            TenthousandPlace = temp % 10;
            temp = temp / 10;
            HundredThousandPlace = temp % 10;
            onePlace = (int)Math.pow(onePlace, 6);
            tenPlace = (int)Math.pow(tenPlace, 6);
            hundredPlace = (int)Math.pow(hundredPlace, 6);
            thousandPlace = (int)Math.pow(thousandPlace, 6);
            TenthousandPlace = (int)Math.pow(TenthousandPlace, 6);
            HundredThousandPlace = (int)Math.pow(HundredThousandPlace, 6);
            result = onePlace + tenPlace + hundredPlace + thousandPlace + TenthousandPlace + HundredThousandPlace;
            if (i == result){
                String numberAsString = String.format("%,d",i);
                System.out.println(numberAsString);
            }
        }
    }
}






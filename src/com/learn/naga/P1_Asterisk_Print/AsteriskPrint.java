package com.learn.naga.P1_Asterisk_Print;

import java.util.Scanner;

/* 
Program to print asterisks in a symmetric diamond pattern of a given size
    @ author: Naga Sakthikumar
 */
public class AsteriskPrint {

    /* 
    Prints the entire pattern for the given size
     */    
    public void printPattern(int size) {
        int count = 0; // just a counter variable
        int increment = 1; // variable to increment. This will increment until half the pattern and then will reverse to print in decreasing order
        int oddOffSet = size % 2; // modulus to figure out if size is even or odd. If even this will be 0, if odd this will be 1
        int middle = (size - oddOffSet)/2; // find the middle of the pattern. Eg: if 4 the halfSize will be 2, if 5 the halfsize will still be 2

        while (count>=0) {

            // print spaces initially
            for (int i = 0; i<middle - count; i++) {
                System.out.print(" ");
            }
            // fill with asterisk pattern
            for (int i = 0; i<(count*2) + oddOffSet; i++) {
                System.out.print("+");
            }
            System.out.println(""); // print a new line
            
            // when at the middle, reverse the increment so pattern will print in decreasing order
            if (count>=middle) {
                increment = -1; // reverse the increment
            }

            //increase count by 1 when printing in ascending pattern, 
            //decrease count by 1 (increment by -1) when printing descending pattern 
            count = count+increment;
        }

    }
    
    public static void main(String[] args) {
        Scanner myObject = new Scanner(System.in);
        int inputVal;

        System.out.println("Pattern size: ");
        inputVal = myObject.nextInt();

        AsteriskPrint obj = new AsteriskPrint();
        obj.printPattern(inputVal);

        myObject.close();          
    }
}
package com.learn.sreya.P1_Asterisk_Print;

import java.util.Scanner;

public class AsteriskPattern {
    public static void main(String args[]) {
        Scanner myObject = new Scanner(System.in);
        int userNum;

        System.out.println("Enter a number please.");
        userNum = myObject.nextInt();

        int x = IntValue(userNum);
        printDiamond(userNum, x);

        myObject.close();
    }

    public static int IntValue(int number){
        if(number % 2 == 1) return 1;
        else return 0;
    }

    public static void printDiamond(int number, int y){
        int middle;
        int num;

        if(y % 2 == 1) middle = (number + 1)/2;
        else middle = number/2;

        for(int x = 1; x <= middle; x++){
            for(int s = 0; s <= middle - x; s++){
                System.out.print(" ");
            }

            for(int a = y; a < 2 * x; a++){
                System.out.print("*");
            }
            System.out.println("");
        }

        for(int x = 1; x <= middle - 1; x++){
            for(int s = 0; s <= x; s++){
                System.out.print(" ");
            }
            if(y % 2 == 1) num = 2 * (middle - x) - 1;
            else num = 2 * (middle - x);
            for(int a = 1; a <= num; a++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}


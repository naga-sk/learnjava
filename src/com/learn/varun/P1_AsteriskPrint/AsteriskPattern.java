package com.learn.varun.P1_AsteriskPrint;

import java.util.Scanner;

public class AsteriskPattern {
    static Scanner keyNum = new Scanner(System.in);

    public static void main(String args[]) {
      int num = keyNum.nextInt();
      int divnum = num/2;
      int count = divnum;
      if(num%2 == 1)
      {
          System.out.println("Odd");
          for(int line = 1; line<=num; line+=2)
          {
              for(int space = count; space>0; space--)
              {
                  System.out.print(" ");
              }
                count--;
              for(int dot = 1; dot<= line; dot++)
              {
                  System.out.print("*");
              }
              System.out.println("");
          }
          int count2 = 1;
          for(int line = num-2; line>0; line-=2)
          {
              for(int space = 0; space<count2; space++)
              {
                  System.out.print(" ");
              }
                count2++;
              for(int dot = 1; dot<= line; dot++)
              {
                  System.out.print("*");
              }
              System.out.println("");
          }
      }
      else if(num%2 == 0)
      {
          System.out.println("Even");
          for(int line = 0; line<=num; line+=2)
          {
              for(int space = count; space>0; space--)
              {
                  System.out.print(" ");
              }
                count--;
              for(int dot = 1; dot<= line; dot++)
              {
                  System.out.print("*");
              }
              System.out.println("");
          }
          int count2 = 1;
          for(int line = num-2; line>0; line-=2)
          {
              for(int space = 0; space<count2; space++)
              {
                  System.out.print(" ");
              }
                count2++;
              for(int dot = 1; dot<= line; dot++)
              {
                  System.out.print("*");
              }
              System.out.println("");
          }
      }
    }    
}
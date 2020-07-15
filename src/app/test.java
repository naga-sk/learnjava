package app;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        
        System.out.println("Enter something");
        Scanner inp = new Scanner(System.in);
        System.out.println(inp.nextLine());

        inp.close();

    }


}
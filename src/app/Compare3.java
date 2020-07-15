package app;

public class Compare3 {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 1;

        if (a > b) {
            if (a > c) {
                System.out.print("Value of a:" + a + " is the biggest");
            } 
            else if (c > a) {
                System.out.print("Value of c:" + c + " is the biggest");
            }
            else {
                System.out.print("Values of a:" + a + " and c:" + c + " are the biggest");
            }
        }
        else if (b > a) {
            if (b > c) {
                System.out.print("Value of b:" + b + " is the biggest");
            }
            else if (c > b) {
                System.out.print("Value of c:" + c + " is the biggest");
            }
            else {
                System.out.print("Values of b:" + b + " and c:" + c + " are the biggest");
            }
        }
        else {
            if (a > c) {
                System.out.print("Values of a:" + a + " and b:" + b + " are the biggest");
            } 
            else if (c > a){
                System.out.print("Value of c:" + c + " is the biggest");
            }
            else {
                System.out.print("Values of a:" + a + " and b:" + b + " and c:" + c + " are the same");
            }
        }
    }
}
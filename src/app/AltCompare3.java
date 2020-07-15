package app;

public class AltCompare3 {

    public static void main(String[] args) {
        int a = 16;
        int b = 10;
        int c = 3;

        if (a>b & a>c) {
            System.out.println("Value of a:" + a + " is the biggest");
        }
        else if (b>a & b>c) {
            System.out.println("Value of b:" + b + " is the biggest");
        }
        else if (c>a & c>b) {
            System.out.println("Value of c:" + c + " is the biggest");
        }
        //System.out.print("*** End ***");
    }

}
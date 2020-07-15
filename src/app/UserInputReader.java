package app;

import java.util.Scanner;

public class UserInputReader {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String line = sc.next();
                if (line.equals("exit")) {
                    break;
                }
                System.out.println ("It was " + line);
            }
            sc.close();
        }
    }
}
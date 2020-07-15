package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String filename = "src/test.txt";

        String line = null;

        try {
            FileReader file = new FileReader(filename);
            BufferedReader bRead = new BufferedReader(file);

            while ((line = bRead.readLine()) != null) {
                System.out.println (line);
            }

            bRead.close();
            file.close();
        } catch (FileNotFoundException FNFE) {
            System.out.println (filename + " was not found");
        } catch (IOException IOE) {
            System.out.println ("something happened" + IOE.getMessage());
        }
    }

}
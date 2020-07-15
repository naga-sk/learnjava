package app;

public class StrTest {
    public static void main(String[] args) {
    
    String str = "My name is ";
    String firstname = "Varun";
    char middleinitial = 'K';
    String lastname = "Nagarajan";

    System.out.println(str + firstname + " " + middleinitial + " "+ lastname);

    String fullname = firstname.concat(" ");
    //fullname.concat(middleinitial);
    fullname.concat(" ");
    fullname.concat(lastname);
    System.out.println (fullname);
    System.out.println ("Number of characters in name is "+ fullname);




    }
}
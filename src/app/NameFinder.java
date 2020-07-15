package app;

public class NameFinder {
    public static void main(String[] args) {
        String[] nameList = {"Ryan Slater", "Bryan Smith", "Jake Bryan", "Ryan Fletcher", "Mike George", "Jindal Aryan"};

        NameFinder a = new NameFinder();
        String[] results = a.findFirstName("Ryan", nameList);
        for (int i=0; i<results.length; i++) {
            System.out.println(results[i]);   
        }
    }
    
    public String[] findFirstName (String firstName, String[] nameList) {
        int n=0;
        String [] matchedName={};
        for (int i=0; i<nameList.length; i++) {
            if (nameList[i].startsWith(firstName)){
            matchedName[n] = nameList[i];
            n++;
            }
        }
        return matchedName;
    }

}

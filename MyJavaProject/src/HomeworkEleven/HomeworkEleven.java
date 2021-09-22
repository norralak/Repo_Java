package HomeworkEleven;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class HomeworkEleven {
    //Task One
    public static HashMap<String, Integer> count (ArrayList<String> arr){
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.size(); i++){ //Loop through list
            int counter = 1; //Amount of times the word repeats
            if (!count.containsKey(arr.get(i).toUpperCase())){ //If the list does not contain the word yet
                for (int j = i+1; j < arr.size(); j++){ //Check to see if it is present again in the list
                    if (arr.get(i).equalsIgnoreCase(arr.get(j))){
                        counter++; //If it is add one to the counter
                    }
                }
            }
            if (counter > 1){ //If the counter is greater than one (not a duplicate or not a non-repeat)
                count.put(arr.get(i).toUpperCase(), counter); //Put it in the map with the count as the value
            }
        }
        return count; //Return our map
    }
    //Task Two
    public static ArrayList<String> maxCount (String[] colors){
        ArrayList<String> maxCount = new ArrayList<>();
        int maxColor = 0; //Count the largest occurence
        ArrayList<String> color = new ArrayList<>(Arrays.asList(colors)); //Requirements states parameter must be array
        HashMap<String, Integer> colours = count(color); //But we make it a List to use the count() method
        for (String clr : colours.keySet()){  //We get a set of how many times a unique key is present
            if (colours.get(clr) > maxColor){ //For each key in the map we will check if the value is greater than maxColor
                maxColor = colours.get(clr); //If it is, we change maxColor to that value
                maxCount.clear(); //Clear the List we are to return
                maxCount.add(clr +": "+ colours.get(clr)); //And add the mode color in
            }
            else if (colours.get(clr) == maxColor){ //If it is the same as maxColor
                maxCount.add(clr +": "+ colours.get(clr)); //We just add it to the List
            }
        }
        return maxCount; //Return our List
    }
    //Task Three Part One
    public static HashMap<Integer, String> userKeyVal (){ //Just so user can enter a custom HashMap into the console
        Scanner read = new Scanner(System.in);
        HashMap<Integer, String> userKeyVal = new HashMap<>();
        String loop = "13";
        while (!loop.equalsIgnoreCase("0")){
            System.out.println("PLEASE ENTER AN INTEGER: ");
            int key = read.nextInt();
            System.out.println("PLEASE ENTER A STRING: ");
            read.nextLine(); //Line buffer
            String val = read.nextLine();
            userKeyVal.put(key, val);
            System.out.println("YOUR HASHMAP: "+userKeyVal);
            System.out.println("TO EXIT PRESS 0, TO CONTINUE ADDING PRESS ANY OTHER KEY: ");
            loop = read.nextLine();
        }
        return userKeyVal;
    }
    //Task Three Part Two (MAIN)
    public static HashMap<String, String> commonVal (HashMap<Integer, String> userMap){
        HashMap<String, String> commonVal = new HashMap<String, String>(); //Our return Map to store duplicates only
        HashSet<String> hasClone = new HashSet<String>(); //Store all unique values
        for (int key : userMap.keySet()){ //For each key in userMap
            if (!hasClone.contains(userMap.get(key).toUpperCase())){ //If hasClone does not contain its key
                hasClone.add(userMap.get(key).toUpperCase()); //Add it to the Set
            }
            else { //If the Set contains the key already
                commonVal.put(userMap.get(key).toUpperCase(), "=>PRESENT IN KEYS: "); //Put it into our return Map
            }
        }
        if (!commonVal.isEmpty()){ //If there are common values
            for (String key : commonVal.keySet()){ //Compare all of commonVal keys to userMap values
                for (int val : userMap.keySet()){
                    if (key.equalsIgnoreCase(userMap.get(val))){ //If they are the same
                        commonVal.put(key, commonVal.get(key)+" "+val); //Concatenate the key of userMap to the existing value of commonVal
                    }
                }
            }
        }
        else { //Otherwise put the Strings below as the return Map's key and value
            commonVal.put("<= ALL KEYS HAVE DIFFERENT VALUES ",">");
        }
        return commonVal; //Return our Map of duplicate values
    }
    //Main function
    public static void main(String[] args) {
        //Task One
        ArrayList<String> norralak = new ArrayList<String>(Arrays.asList("Norralak", "Angie", "Angthong", "Torsak", "Mew", "Pop", "Norralak", "Torsak", "Angthong", "Norralak"));
        HashMap repeatVal = count(norralak);
        System.out.println("Repeating Values: "+repeatVal);
        /**
         * Norralak -> 3
         * Angthong -> 2
         * Torsak -> 2
         */
        //Task 2
        String[] colorArr = {"green", "blue", "red", "yellow", "grey", "green", "red", "grey",
                "green", "red", "yellow", "yellow", "grey", "blue", "yellow", "grey",
                "green", "blue", "yellow", "grey", "green", "blue", "green", "green",
                "green", "green", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange", "orange",};
        System.out.println(maxCount(colorArr)); //Expected Green: 9 Orange: 9
        //Task Three
        HashMap<Integer, String> comValTest = new HashMap<>();
        comValTest.put(7, "NORRALAK");
        comValTest.put(13, "ANGIE");
        comValTest.put(1, "NORRALAK");
        comValTest.put(2, "ANGIE");
        comValTest.put(3, "ANGTHONG");
        comValTest.put(4, "TORSAK");
        comValTest.put(6, "MEW");
        comValTest.put(5, "POP");
        comValTest.put(8, "MEW");
        comValTest.put(9, "ANGIE");
        comValTest.put(10, "nOrRaLaK");
        comValTest.put(11, "pOp");
        System.out.println(commonVal(comValTest));
        comValTest.clear();
        comValTest = userKeyVal(); //User input key-value pairs
        System.out.println(commonVal(comValTest));
    }
}

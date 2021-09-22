package HomeworkEleven;

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
    }
}

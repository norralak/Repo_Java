package HomeworkTen;
import java.util.*;
import java.util.ArrayList;

public class HomeworkTen {
    //Task One
    public static ArrayList<String> commonWords (String[] firstArr, String[] secondArr){
        ArrayList<String> commonWords = new ArrayList<String>(); //List to hold common words
        for (String word : firstArr){ //For each word in the first array
            for (String w2rd : secondArr){ //Check if it is present in any of the second's indices
                if (word.equalsIgnoreCase(w2rd) && !commonWords.contains(word.toUpperCase())){ //If it is and is not already added
                    commonWords.add(word.toUpperCase()); //Add the word to our commonWords return
                    break; //Go on to the next word in the first array
                }
            }
        }
        return commonWords; //In the end we return our list of common words
    }
    //Task Two
    public static ArrayList<String> repeatValues (String[] words){
        ArrayList<String> repeatValues = new ArrayList<String>();
        for (int i = 0; i < words.length; i++){ //Starting with the first word
            for (int j = i + 1; j < words.length; j++){ //Check to see if the same word appears again in the array
                if (words[i].equalsIgnoreCase(words[j]) && !repeatValues.contains(words[i].toUpperCase())){ //If repeated values does not yet contain a repeated value
                    repeatValues.add(words[i].toUpperCase());
                    break;
                }
            } //Repeat until end of array
        }
        return repeatValues; //Return repeatValues list
    }
    //Task Three
    public static int count (String word, String[] arr){
        int count = 0;
        for (String words : arr){ //For every index in the array
            if (word.equalsIgnoreCase(words)){ //If the given word is equal to one of the indices
                count++; //Add one to count
            }
        }
        return count;
    }
    public static void main(String[] args) {
        //Task One
        String[] norralak = {"Norralak", "Angie", "Angthong", "Torsak", "Mew", "Pop", "Norralak", "Torsak", "Angthong", "Norralak"};
        String[] kalarron = {"Norralak", "Torsak", "Angthong", "Quality Assurance", "Java", "Selenium", "REST API"};
        ArrayList<String> commonWords = commonWords(norralak, kalarron); //Should return "Norralak", "Torsak", "Angthong"
        System.out.println("Common Words Include: "+commonWords);
        //Task Two
        ArrayList<String> repeatValues = repeatValues(norralak); //Should return "Norralak", "Torsak", "Angthong"
        System.out.println("Repeat Values Include: "+repeatValues);
        //Task Three
        for (int i = 0; i < 6; i++){ //Only six unique values
            System.out.println(norralak[i]+" Appears "+count(norralak[i], norralak)+" Time(s)");
        }
        /**
         * Norralak -> 3
         * Angie -> 1
         * Angthong -> 2
         * Torsak -> 2
         * Mew -> 1
         * Pop -> 1
         */
    }
}

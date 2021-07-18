/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkTwo;

/**
 *
 * @author Norralak
 */
public class HomeworkTwo {
    public static void main (String [] args){
        // Question - 1
        String firstSentence = "hello dear, how are you?";
        int firstResult = 0;
        /**
         * Assign firstResult as 100 if the length of firstResult is 10 or greater
         * else assign firstResult as 15
         *
         * use: Ternary operator
         *
         */
        firstResult = firstSentence.length() >= 10 ? 100 : 15; //If length is 10 or greater first result is 100, else it is 15
        System.out.println("firstResult = " + firstResult); //Prints firstResult = 100

        // Question - 2
        String secondSentence = "We all ARe GOod ProgrAMmer";
        /**
         * replace all 'R/r' with 'F'
         */
        System.out.println(secondSentence); //Print original first
        secondSentence = secondSentence.replace('r', 'F');//We can change to uppercase/lowercase to ignore cases but intended result is to have miscellaneous uppercase/lowercase chars stay the same
        secondSentence = secondSentence.replace('R', 'F');//Thus we account for both lower and uppercase instances of the char 'R'
        System.out.println(secondSentence);// Now print intended result "We all AFe GOod PFogFAMmeF";

        // Question - 3
        String thirdSentence = "ABC Networks";
        String thirdResult = "";
        /**
         * 1. Display/Print length of your thirdSentence
         * 2. does thirdSentence starts with "a" (ignore cases)
         * 3. does thirdSentence ends with "K" (ignore cases)
         * 4. Assign thirdResult as "Media" if thirdSentence starts with 'a' (ignore cases)
         *      else assign "Entertainment"
         *      Print the thirdResult in console.
         */
        System.out.println("thirdSentence Length = "+thirdSentence.length()); //Should print thirdSentence Length = 12
        System.out.println("thirdSentence starts with an 'a'/'A': "+thirdSentence.toUpperCase().startsWith("A")); //We can also do thirdSentence.charAt().equalsIgnoreCase('a') to check but not sure how you'd like me to do it
        System.out.println("thirdSentence starts with an 'k'/'K': "+thirdSentence.toUpperCase().startsWith("K")); //See comment above
        thirdResult = thirdSentence.toLowerCase().startsWith("a") ? "Media" : "Entertainment";
        System.out.println(thirdResult); //Should print Media since it starts with A
    }
}

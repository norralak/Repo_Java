/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkSeven;

import java.util.Arrays;

/**
 *
 * @author Norralak
 */
public class HomeworkSeven {
    
    //Task 1: Case Fix
    public static String caseFix(String testSentence){
        String[] arrSentence = testSentence.split(" "); //Store each word into a corresponding index of this String array
        String formatted = ""; //Initialize empty String
        for (String word : arrSentence) { //Go through each word in the array
            formatted += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase(); //String formatted will equal to itself plus the word's first letter capitalized and the rest of the word lowercase
            //Add spaces unless it's the last word.
            if (!word.equalsIgnoreCase(arrSentence[arrSentence.length-1])){
                formatted += " ";
            }
        } //It will keep fixing each word in the array and adding it to the String formatted until it reaches the end of the array
        System.out.println("ORIGINAL STRING: "+testSentence); //Output the original
        System.out.println("FIXED STRING: "+formatted); //Output the fixed String
        return formatted; //Return the formatted String value
    }
    //Task 2: Reverse String
    public static String reverseString(String testWord){
        String reverseWord = ""; //Empty String for storing the reversed word/String
        for (int letter = testWord.length() - 1; letter >= 0 ; letter--){ //Start from the last character of the string
            reverseWord += testWord.charAt(letter); //Add it to the corresponding index of the backwards string array
        }
        System.out.println("ORIGINAL STRING: "+testWord); //Print the original
        System.out.println("REVERSED STRING: "+reverseWord); //Print the reversed
        return reverseWord; //Return the reversed value
    }
    //Task 3: Palindrome Check
    public static boolean isPalindrome(String testWord){
        boolean isPalindrome = true; //It's a palindrome until proven it isn't!
        int forWords = 0; //From the first character of the String
        int backWords = testWord.length() - 1; //From the last character of the String
        testWord = testWord.trim(); //Take out the spaces!
        while (forWords <= backWords) {
            //As long as the count going forward is less than or equal to the count going backwards (meaning we haven't passed the middle
            if (testWord.toUpperCase().charAt(forWords) != testWord.toUpperCase().charAt(backWords)) {
                //If it does not equal then it's not a palindrome!
                isPalindrome = false; //It is not a palindrome
                break; //Break the loop
            }
            forWords++; //Check next character going forward
            backWords--; //Compared to previous character going backwards
        }
        if (isPalindrome) {
            System.out.println(testWord + " IS A PALINDROME.");
        } 
        else {
                System.out.println(testWord + " IS NOT A PALINDROME.");
        }
        return isPalindrome;  //Return true or false value  
    }
    //Alternate way! 
    //This way is easier to type, but I think that the speed and efficacy of the first method is better
    public static boolean palindrome(String testWord){
        boolean isPalindrome = false; //Isn't a palindrome until proven it is!
        if (reverseString(testWord).equalsIgnoreCase(testWord)){
            isPalindrome = true;
        }
        if (isPalindrome) {
            System.out.println(testWord + " IS A PALINDROME.");
        } 
        else {
                System.out.println(testWord + " IS NOT A PALINDROME.");
        }
        return isPalindrome;  //Return true or false value  
    }
    
    //Task 4: Max Value
    public static int maxVal(int[] numbers){
        int maxVal = numbers[0]; //Assume first index is the largest
        for(int i = 1; i < numbers.length; i++){ 
            if (numbers[i]>= maxVal){ //If the number is greater than maxVal
                maxVal = numbers[i]; //It becomes the new maxVal
            }
        }
        System.out.println("IN THE FOLLOWING ARRAY OF NUMBERS :"+Arrays.toString(numbers));
        System.out.println(maxVal+" IS THE LARGEST VALUE!");
        return maxVal;
    }
    //Main function
    public static void main(String[] args){

        //Task 1
        System.out.println("**T*A*S*K*****#1**");
        String mySentence = "mY nAmE iS NoRrAlAK aNd i NeeD mOnEy!";
        mySentence = caseFix(mySentence); //Reassigning the value. Now everytime you print mySentence, it will be formatted.
        System.out.println(mySentence);

        //Task 2
        System.out.println("**T*A*S*K*****#2**");
        String[] wordTest = {"TORSAK", "ANGTHONG", "NORRALAK", "ANGIE", "UMBRA DEOS"};
        for (int i = 0; i < wordTest.length; i++){
            wordTest[i] = reverseString(wordTest[i]); //Reassigning the values
        } //Now everytime you print wordTest it will be reversed, since we reassigned on the line above.
        System.out.println(Arrays.toString(wordTest));

        //Task 3
        System.out.println("**T*A*S*K*****#3**");
        String[] testWords = {"RACECAR", "TACOCAT", "NORRALAK", "ANGIE", "TORSAK", "ANGTHONG", "KAYAK", "LEVEL"};
        //Store boolean value in array equal to the array length of words we are testing
        boolean[] palResults = new boolean[testWords.length];
        for (int i = 0; i < testWords.length; i++){
            palResults[i] = false; //Initialize to be false first
            palResults[i] = isPalindrome(testWords[i]); //Then set its value based on the return value of the function
        }
        //You can check which index is a palindrome or not
        System.out.println("PALINDROME ROLL CALL!");
        System.out.println(Arrays.toString(palResults).toUpperCase());

        //Test the alternate method
        System.out.println("*A*L*T*E*R*N*A*T*E*");
        for (int i = 0; i < testWords.length; i++){
            palResults[i] = false; //Initialize to be false first
            palResults[i] = palindrome(testWords[i]); //Then set its value based on the return value of the function
        }
        //You can check which index is a palindrome or not
        System.out.println("PALINDROME ROLL CALL!");
        System.out.println(Arrays.toString(palResults).toUpperCase());
        //Task 4
        System.out.println("**T*A*S*K*****#4**");
        int[] testNums = {13, 6, 23, 2, 0, 7, 12, 26, 8, 1};
        int bigNum = maxVal(testNums); //Return the value and store it in bigNum
        System.out.println(bigNum); //Let's see what value bigNum is
    }
}

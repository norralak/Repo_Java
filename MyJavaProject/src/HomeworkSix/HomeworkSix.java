/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkSix;

import java.util.Arrays;

/**
 *
 * @author Norralak
 */
public class HomeworkSix {
    public static void main (String[] args){
        //Task 1: Palindromes
        String[] testWords = {"RACECAR", "TACOCAT", "NORRALAK", "ANGIE", "TORSAK", "ANGTHONG", "KAYAK", "LEVEL"};
        for (int i = 0; i < testWords.length; i++){ //Test every string in the array
            boolean isPalindrome = true; //It's a palindrome until proven it isn't!
            int forWords = 0; //From the first character of the String
            int backWords = testWords[i].length() - 1; //From the last character of the String
            while (forWords <= backWords){ //As long as the count going forward is less than or equal to the count going backwards (meaning we haven't passed the middle
                if (testWords[i].toUpperCase().charAt(forWords) != testWords[i].toUpperCase().charAt(backWords)){ //If it does not equal then it's not a palindrome!
                    isPalindrome = false; //It is not a palindrome
                    break; //Break the loop
                }
                forWords++; //Check next character going forward
                backWords--; //Compared to previous character going backwards
            }
            if (isPalindrome){
                System.out.println(testWords[i]+" IS A PALINDROME.");
            }
            else {
                System.out.println(testWords[i]+" IS NOT A PALINDROME.");
            }
        }
        //Task 2: Primes
        int[] testNums = {13, 6, 23, 2, 0, 7, 12, 26, 8, 1};
        for (int i = 0; i < testNums.length; i++){
            boolean isPrime = true; //Prime until proven it isn't!
            int j = 2; //Can't start at 0 or 1, since it'll be proven false according to the code logic
            do {
                if (testNums[i] == 2 || testNums[i] == 1){ //One and two are primes
                    break; //So we stop checking
                }
                else if (testNums[i] % j == 0 || testNums[i] < 0){ //If it's divisible by a integer two or greater or a negative integer
                    isPrime = false; //Then it isn't prime
                    break;          //So we stop checking
                }
                else {
                    j++;
                }
            } while (j <= testNums[i]/2); //I chose do-while because I want it to go above the halfway point before breaking the loop
            if (isPrime){
                System.out.println(testNums[i]+" IS A PRIME NUMBER.");
            }
            else {
                System.out.println(testNums[i]+" IS NOT A PRIME NUMBER.");
            }
        }
        //Task 3: Reversing Words
        //Using word array made in the first task
        String[] reverseWords = new String[testWords.length]; //Storing the backwards strings
        for (int i = 0; i < testWords.length; i++){
            reverseWords[i] = ""; //Initialize the string;
            for (int j = testWords[i].length() - 1; j >= 0 ; j--){ //Start from the last character of the string
                reverseWords[i] += testWords[i].charAt(j); //Add it to the corresponding index of the backwards string array
            }
        }
        System.out.println("FORWARDS THEN BACKWARDS");
        System.out.println(Arrays.toString(testWords));
        System.out.println(Arrays.toString(reverseWords));
        
        //Task 4: Vowels
        String[] vowTest = {"TORSAK", "ANGTHONG", "NORRALAK", "ANGIE", "UMBRA DEOS"};
        for (String word : vowTest){ //Using the same string array
            int vowCount = 0; //Count the vowels
            for (int i = 0; i < word.length(); i++){
                char testChar = word.toUpperCase().charAt(i); //This way I don't have to type a million times
                if (testChar == 'A' || testChar == 'E' || testChar == 'I' || testChar == 'O' || testChar == 'U'){
                    vowCount++;
                }    
            }
            System.out.println(word+" HAS "+vowCount+" VOWELS");
        }
    } 
}

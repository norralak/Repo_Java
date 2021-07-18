/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkThree;
import java.util.Arrays;

/**
 *
 * @author Norralak
 */
public class HomeworkThree {
    public static void main(String[] args) {

        // Due: July 18

        // Question - 1:
        /**
         * String threeWordSentence = "hApPy nEW yeAr"
         * // code
         * String threeWordSentence = "Happy New Year"
         */
        String threeWordSentence1 = "hApPy nEW yeAr";
        System.out.println("Before code : " + threeWordSentence1);     // "hApPy nEW yeAr"
        // code
        threeWordSentence1 = threeWordSentence1.toLowerCase(); //Change all to lowercase
        String [] arr1 = threeWordSentence1.split(" ");
        //Many more efficient ways to do so but I am trying to restrict myself to what we've learned in class so far.
        arr1[0] = arr1[0].substring(0, 1).toUpperCase() + arr1[0].substring(1);
        arr1[1] = arr1[1].substring(0, 1).toUpperCase() + arr1[1].substring(1);
        arr1[2] = arr1[2].substring(0, 1).toUpperCase() + arr1[2].substring(1);
        threeWordSentence1 = arr1[0] + " "+arr1[1]+" "+arr1[2]; //Reassigning value of string with values of each array index as 1 string.
        System.out.println("After code : " + threeWordSentence1);      // "Happy New Year"


        // Question - 2:
        /**
         * create the abbreviation  // HNY
         */
        String threeWordSentence2 = "very gOOD MorNING";
        String abbr = "";

        // code
        String [] arr2 = threeWordSentence2.split(" "); //Split the words and make each word an index of arr2
        //Change first letter of each index of arr2 to uppercase, then reassign the value of abbr to those values as a string altogether
        abbr = arr2[0].substring(0,1).toUpperCase() + arr2[1].substring(0,1).toUpperCase() + arr2[2].substring(0,1).toUpperCase(); 
        System.out.println("Abbreviation for '" + threeWordSentence2 + "' is : " + abbr);
        // Abbreviation for 'very gOOD MorNING' is : VGM


        // Question - 3:
        /**
         * print the number of words in the sentence.
         */
        String sentence3 = "We all are here to learn programming and testing";
        String [] arr3 = sentence3.split(" ");
        System.out.println("Length of the third sentence is: "+arr3.length);







    }
}

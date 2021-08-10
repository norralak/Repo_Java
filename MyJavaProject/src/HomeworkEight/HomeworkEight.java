/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkEight;

import java.util.Arrays;
import HomeworkSeven.HomeworkSeven; //We're gonna be using maxVal

/**
 *
 * @author Norralak
 */
public class HomeworkEight {
    //Task 1
    public static String[] findWord (String[] arr, String search){
        int count = 0;
        for (String word : arr) {
            if (word.toUpperCase().contains(search.toUpperCase())) {
                //If the word ignoring case contains the word we search for
                count++; //Add the count by 1        
            }
        } //Now since we know how many words there are
        String[] arrModified = count == 0 ? new String[1] : new String[count]; //Modified array with only words that contain the searched word will have that amount for its length or it will have 1 (NONE)
        if (count != 0){ //If the searched word was contained in the array
            int j = 0, k = 0; //j is to go through arr elements while k is to count arrModified indexes
            while (j < arr.length && k < count){ //Go through the array or until the count is reached
                if (arr[j].toUpperCase().contains(search.toUpperCase())){ //Does element in arr contain search?
                    arrModified[k] = arr[j].toUpperCase(); //Modified array will now contain that word....I mzde it uppercase to look nice
                    k++; //Next index of modified array
                }
                j++; //Next element of arr
            }
        }
        else {
            arrModified[0] = "NONE"; //If the searched word was not found
        }
        return arrModified;
    }
    //Task 2
    public static String[] maxString(String[] arr){
        int[] wrdLen = new int[arr.length]; //Array of length of each word;
        for (int i = 0; i < arr.length; i++){ //Input value into each index
            wrdLen[i] = arr[i].length();
        }
        int bigLen = HomeworkSeven.maxVal(wrdLen); //Largest length of a word
        int count = 0; //How many in arr have lengths equal to bigLen?
        for (String word : arr){ //Check how many words have this length
            if (word.trim().length() == bigLen){ //Take out the spaces
                count++; //Amount of words our return array should have!
            }
        }
        String[] maxString = new String[count]; 
        int j = 0; //Count our maxString indexes
        for (int i = 0; i < arr.length && j < count; i++){
            if(arr[i].trim().length() == bigLen){ //If the element's length is equal to the largest
                maxString[j] = arr[i]; //We shall add it in our maxString array
                j++; //Increase our array
            }
        }
        return maxString;
    }
    //main method
    public static void main (String[] args){
        //Task 1
        String[] testArr = {"TORSAK", "ANGTHONG", "NORRALAK", "ANGIE", "UMBRA DEOS"};
        String search = "oR"; //Change this variable to teet function
        System.out.println(Arrays.toString(findWord(testArr, search)));
        //Task 2
        System.out.println(Arrays.toString(maxString(testArr)));

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testOne;

import java.util.Arrays;
import HomeworkSeven.HomeworkSeven; //We will use maxVal

/**
 *
 * @author Norralak
 */
public class testOne {
    //Methods
    
    //Task 1
    public static void traffiCop(int speed){ //In my defense, I have never seen a speedometer have decimal points
        int points = 0; //Points on license
        int speedLimit = 70;
        if (speed < 75 && speed > 0){ //If under 75 MPH
            System.out.println("  USER SPEED  : "+speed);
            System.out.println("LICENSE POINTS: "+points);
        }
        else if (speed < 0){ //Impossible to go under 0 MPH
            points = -1;
            System.out.println("  USER SPEED  : "+speed);
            System.out.println("LICENSE POINTS: INVALID");
        }
        else if (speed >= 75){ //If over 75 MPH
            points = (speed - 70)/5; //Every five over 70 will result in a point
            System.out.println("  USER SPEED  : "+speed);
            System.out.println("LICENSE POINTS: "+points);
        }
        if (points < 0){ //Literally impossible
            System.out.println("YOU ARE A MAGICIAN");
        }
        else if (points == 0){ //If they have no points
            System.out.println("THANK YOU FOR DRIVING UNDER THE SPEED LIMIT");
        }
        else if (points > 0 && points < 12){ //If they have a point or more but not suspended yet
            System.out.println("PLEASE DRIVE WITHIN THE SPEED LIMIT");
        }
        else if (points >= 12){ //If points is twelve or over
            System.out.println("LICENSE SUSPENDED");
        }
        
    }
    
    //Task 2
    public static int[] findNum(int search, int[] num){
        //First count how many times the number appears
        int count = 0;
        for (int n : num){ //Go through each index
            if (n == search){ //If it is the number we are searching for
                count++; //Increase the count by one
            }
        } //Now we know how big to make our return array
        int[] purgedArr = new int[num.length - count];
        if (count == 0){ //If we can't find the number then return the original one
            purgedArr = num;
        }
        else { //But if there is....
            int j = 0; //Represents indexes of our return array
            for (int i = 0; i < num.length && j < num.length - count; i++){ //For the length of num or purgedArr
                if (search != num[i]){ //If it is the number
                    purgedArr[j] = num[i]; //Copy it to the purged array
                    j++; //Iterate purged array to next index
                }
                    //Otherwise do not iterate
            }
        }
        
        return purgedArr;
        
    }
    
    //Task 3
    
    //First we make a method to find the smallest positive integer
    public static int smolPos (int [] num){
        int smolPos = num[0]; //Assume first one is the smallest
        for (int n : num){ //For each array element
            if (smolPos >= n && n >= 0){ //If the element is positive and smaller than smolPos
                smolPos = n; //It shall become the new smolPos
            }
        }
        if (smolPos < 0){ //Default if there are only negatives
            smolPos = 0; 
        }
        return smolPos;
    }
    
    public static int missingSmol (int[] arrNum){
        int missingSmol = 0; //Our return value
        int maxVal = HomeworkSeven.maxVal(arrNum); //Find the largest value
        int smolPos = smolPos(arrNum); //Smallest positive integer
        if (maxVal - smolPos <= 0){ //This is only true if there are only negative numbers
            missingSmol = 1; //If no positive numbers return one as per the requirements
        }
        else { //Otherwise we run the code
            for (int i = smolPos; i <= maxVal; i++){ //Check if it is equal to all the numbers from smolPos to maxVal
                boolean found = false; //Assume the number is missing
                for (int j = 0; j < arrNum.length; j++){ //Go through arrNum
                    if (arrNum[j] == i){ //If this element is equal any number smolPos - maxVal inclusive
                        found = true; //We did find the number, so this is not the missing number
                        break; //Stop checking and go to the next index of arrNum
                    }
                } //If we end up going through all of arrNum  
                if (!found){ //And found is still false 
                    missingSmol = i; //Ladies and gentlemen, we got him (this is the smallest missing number from smolPos to maxVal)
                    break; //Stop checking 
                }
            }
        }
        //Oof that was kinda tough
        return missingSmol;
    }
    
    
    public static void main (String[] args){
        //Task 1
        int[] speed = {-13, 52, 74, 75, 129, 130, 143}; //Invalid, under, slightly over but no points, one point, multiple points, suspension, over suspension
        for (int mph : speed){ //Test all speeds above
            traffiCop(mph);
            System.out.println("******------*------******"); //Separate test cases
        }
        //Task 2
        int[] testNums = {1, 26, 6, 23, 7, 12, 8, 13, 1, 7, 12, 6, 23};
        for (int i =  0; i < testNums.length; i++){
            System.out.println(Arrays.toString(testNums)+" REMOVE "+testNums[i]); //Print original
            System.out.println(Arrays.toString(findNum(testNums[i], testNums))); //Print purged
            System.out.println("******------*------******"); //Separate test cases
        }
        //Test for none changed
        System.out.println("CHANGE NOTHING");
        System.out.println(Arrays.toString(findNum(130, testNums)));
        System.out.println("******------*------******"); //Separate test cases
        
        //Task 3
        int[] firstTest = {-2, -5, -1, -10, -6};
        System.out.println("SMALLEST MISSING POSITIVE INTEGER: "+missingSmol(firstTest)); //My max val will print the full array
        System.out.println("******------*------******"); //Separate test cases
        int[] secondTest = {0, 5, -1, 1, 2, 5, 3, 7, 1, 2};
        System.out.println("SMALLEST MISSING POSITIVE INTEGER: "+missingSmol(secondTest)); //My max val will print the full array
        System.out.println("******------*------******"); //Separate test cases
        int[] thirdTest = {2, 5, -1, 0, 6};
        System.out.println("SMALLEST MISSING POSITIVE INTEGER: "+missingSmol(thirdTest)); //My max val will print the full array
        System.out.println("******------*------******"); //Separate test cases
        int[] fourthTest = {3, 5, 1, 4, 2, 7};
        System.out.println("SMALLEST MISSING POSITIVE INTEGER: "+missingSmol(fourthTest)); //My max val will print the full array
        System.out.println("******------*------******"); //Separate test cases
        int[] myTest = {3, 5, 13, 4, 6, 7}; //Should return 8
        System.out.println("SMALLEST MISSING POSITIVE INTEGER: "+missingSmol(myTest)); //My max val will print the full array
        System.out.println("******------*------******"); //Separate test cases
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testOne;

import java.util.Arrays;

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
        int j = 0; //Represents indexes of our return array
        for (int i = 0; i < num.length && j < num.length - count; i++){ //For the length of num or purgedArr
            if (search != num[i]){ //If it is the number
                purgedArr[j] = num[i]; //Copy it to the purged array
                j++; //Iterate purged array to next index
            }
                //Otherwise do not iterate
        }
        
        return purgedArr;
        
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
        System.out.println(Arrays.toString(findNum(130, testNums)));
    }
}

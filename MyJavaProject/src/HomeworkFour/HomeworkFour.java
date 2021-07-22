/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkFour;

/**
 *
 * @author Norralak
 */
public class HomeworkFour {
    public static void main(String [] args){
        //Creating a variable to store studentScore and maxScore.
        //07/22/2021 Re Committing I deleted by accident
        int studentScores [] = {80, 112, 97, 62, 143, 133, 18};
        int maxScore = 150;
        //I made an array where each index holds the value of a student's score.
        //Based on %, display the student's grade.
        /**
         * A: 100 - 91
         * B: 90.00 - 81
         * C: 80.99 - 71
         * D: 70.99 - 61
         * E: 60.99 - 51
         * F: 50.99 or below
         */
        //Change which value to test by changing the value of int variable stdnt
        int stdnt = 4;  // You can test each of the array value by changing this from 0-6
        double pct = 100.0 * studentScores[stdnt]/maxScore; //Student's score out of 150 times 100 for %
        String grade = ""; //String variable that will either be A B C D E F depending on pct
        if (pct >= 91.0){
            grade  = "A";
        }
        else if (pct >= 81.0){
            grade  = "B";
        }
        else if (pct >= 71.0){
            grade  = "C";
        }
        else if (pct >= 61.0){
            grade  = "D";
        }
        else if (pct >= 51.0){
            grade  = "E";
        }
        else if (pct < 50.9999 && pct >= 0.0){
            grade  = "F";
        }
        else {
            grade ="INVALID GRADE";
        }
        System.out.println("Hello Student #"+stdnt+". Your score is of "+studentScores[stdnt]+" out of "+maxScore);
        System.out.println("Your percentage: "+pct+"%");
        System.out.println("Your grade: "+grade);
        /**
         * If number is divisible by 3 print divisible by three.
         * If it's divisible by 5 print divisible by five.
         * If it's divisible by both print divisible by both.
         */
        int [] num = {9, 25, 225, 13}; //Divisible by 3, 5, both and none respectively. 
        //You can change what variable to test by changing the nbr value from 0-3
        int nbr = 2;
        //True or false. Didn't need this extra step but it looks clean and good practice of ternary
        boolean divTres = num[nbr]%3 == 0 ? true : false;
        boolean divFive = num[nbr]%5 == 0 ? true : false;
        boolean divBoth = divTres && divFive ? true : false;
        //We can easily use if and else
        if (divBoth){ //If divBoth is true
            System.out.println(num[nbr]+" is divisible by three and five.");
        } 
        else if (divFive){ //If divFive is true
            System.out.println(num[nbr]+" is divisible by five.");
        }
        else if (divTres){ //If divTres is true
            System.out.println(num[nbr]+" is divisible by three.");
        }
        else { //If none of the above are true
            System.out.println(num[nbr]+" is neither divisibly by three nor five.");
        }
    }
}

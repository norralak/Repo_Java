/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkFive;

import java.util.Arrays;

/**
 *
 * @author Norralak
 */
public class HomeworkFive {
    public static void main(String [] args){
        //Prompt 1
        //This sentence is very true, but let's make it grammatically correct
        String mySentence = "mY nAmE iS NoRrAlAK aNd i NeeD mOnEy!";
        String [] arrSentence = mySentence.split(" ");
        String formatted = "";
        for (int i = 0; i < arrSentence.length; i++) {
            formatted += arrSentence[i].substring(0,1).toUpperCase() + arrSentence[i].substring(1).toLowerCase();
            //Add spaces unless it's the last word.
            if (i != arrSentence.length - 1){
                formatted += " ";
            }
        }
        //Print formatted sentence
        System.out.println(formatted);
        
        //Prompt 2
        String abbr = ""; //Empty string
        for (int i = 0; i < arrSentence.length; i++){
            abbr += arrSentence[i].toUpperCase().charAt(0); //Add first letter capitalized to String abbr
        }
        //Print abbreviation
        System.out.println(formatted +" ABBREVIATION: "+abbr);
        
        //Prompt 3
        //COPIED AND PASTED FROM HOMEWORK 4
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
        //Print for each student!
        for (int stdnt = 0; stdnt < studentScores.length; stdnt++){
            double pct = 100.0 * studentScores[stdnt]/maxScore; //Student's score out of 150 times 100 for %
            String grade = ""; //String variable that will either be A B C D E F depending on pct
            //HW 5 SCHOLARSHIP; Could represent as boolean and then print based on that but it's easier to do a string.
            String scholarship = "QUALIFIED SCHOLARSHIP FOR NEXT YEAR: ";
            if (pct >= 91.0){
                grade  = "A";
                scholarship += "FULL RIDE";
            }
            else if (pct >= 81.0){
                grade  = "B";
                scholarship += "HALF SCHOLARSHIP";
            }
            else if (pct >= 71.0){
                grade  = "C";
                scholarship += "HALF SCHOLARSHIP";
            }
            else if (pct >= 61.0){
                grade  = "D";
                scholarship += "NONE";
            }
            else if (pct >= 51.0){
                grade  = "E";
                scholarship += "NONE";
            }
            else if (pct < 50.9999 && pct >= 0.0){
                grade  = "F";
                scholarship += "NONE";
            }
            else {
                grade ="INVALID GRADE";
                scholarship += "NONE";
            }
            System.out.println("HELLO STUDENT #"+(stdnt+1)+". YOUR SCORE IS "+studentScores[stdnt]+" OUT OF "+maxScore);
            System.out.println("YOUR PERCENTAGE: "+pct+"%");
            System.out.println("YOUR GRADE: "+grade);
            System.out.println(scholarship);
        }
        
        //Prompt 4
        int[] arrNum = {26, -7, -6, 23, 29};
        double avg = 0;
        for (int i = 0; i < arrNum.length; i++){
            avg += arrNum[i];
        }
        avg /= (arrNum.length);
        System.out.println("THE AVERAGE OF "+Arrays.toString(arrNum)+" IS "+avg);
        //Prompt 5
        String[] arrWords = {"john", "happy", "peACe", "jOy", "lui", "harry"};
        boolean found = false; //For purposes of repeating values in the array
        String match = "Norralak"; //I'm going to ignore case because not specified; Change this variable to test
        for (int i = 0; i < arrWords.length; i++){
            if(arrWords[i].equalsIgnoreCase(match)){ //If found
                System.out.println(match.toUpperCase()+" WAS FOUND IN POSITION "+(i+1)); //I made console print match uppercase because it looks nicer
                found = true; //In case there are multiple but if we only account for 1 in a list then this line would say break
            }
            else if (i == arrWords.length - 1 && !found){ //If it was never matched in the whole loop
                System.out.println(match.toUpperCase()+" WAS NOT FOUND IN THE LIST"); //Uppercase looks better
            }
        }
        //Prompt 6
        int[] arrNumbers = {11, 22, 33, 44, 55, 13, 65};
        found = false;
        String[] arrNames = {"john", "happy", "peACe", "jOy", "LEarN", "joy", "laugh"};
        int search = 13; //The prompt is 33 but 13 is my fav number. Change this variable to test certain things.
        //First let's make sure array length is the same for both.
        if (arrNumbers.length == arrNames.length){
            //Only search if they're the same length
            for (int i = 0; i < arrNumbers.length; i++){
                if (arrNumbers[i] == search){ //If we find our number
                    System.out.println(search+" WAS FOUND AT POSITION "+(i+1));
                    System.out.println("THE WORD ASSOCIATED WITH THIS POSITION IS: "+arrNames[i]);//I would love to capitalize here so it looks good but let's not :)
                }
                //If it was not found
                else if (!found && i == arrNumbers.length - 1){
                    System.out.println(search+" WAS NOT FOUND.");
                }
            }
        }
        else { //If array does not have the same length
            System.out.println("ERROR: ARRAYS DO NOT HAVE THE SAME LENGTH");
        }
        //Prompt 7
        String[] nameList = {"john", "happy", "peACe", "jOy", "LEarN", "Orange", "king kong", "iRON MAN"};
        for (int i = 0; i < nameList.length; i++){
            if (nameList[i].length() >=5 && nameList[i].toUpperCase().contains("O")){
                System.out.println(nameList[i]+" contains an o/O");
            }
        }
    }
        
}

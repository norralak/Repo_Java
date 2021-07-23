/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkFive;

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
            String scholarship = "QUALIFIED SCHOLARSHIP: ";
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
        //Let's use the string 
    }
}

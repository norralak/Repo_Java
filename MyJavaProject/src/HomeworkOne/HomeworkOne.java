/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeworkOne;

/**
 *
 * @author Norralak
 */
public class HomeworkOne {
    public static void main (String[] args){
        //Convert Celcius to Fahrenheit
        double cTemp = 100;
        double fTemp = cTemp * 9/5 +32;
        System.out.println(cTemp+" degrees celcius is equal to "+fTemp+" degrees fahrenheit.");
        //Reverse
        fTemp = 100;
        cTemp = (fTemp-32)*5/9;
        System.out.println(fTemp+" degrees fahrenheit is equal to "+cTemp+" degrees celcius.");
        //Number of hours in a day
        byte hours = 24;
        System.out.println("There are "+hours+" in a day!"); ////Will print There are 24 hours in a day!
        //Maximum number of days in a year
        int days = 366;
        System.out.println("The maximum amount of days in a year can be "+days+"!"); //Will print The maximum amount of days in a year can be 366 days!
        //Total employees in an organization
        int employees = 20;
        System.out.println("This company has "+employees+" employees."); //Will print This company has 20 employees.
        //Population in a country
        int popu = 20534003;
        System.out.println("Greenland has a population of "+popu+"."); //Will print Greenland has a population of 20534003.
        //Mortgage rate
        double mRate = 0.035;
        System.out.println("The mortgage rate as of 2021 for FHA qualifiers is: "+(mRate*100)+"%."); //Will print The mortgage rate as of 2021 for FHA qualifiers is: 3.5%.
        //Bank account balance
        double balance = 0.00; //Accurate depiction of my account :)
        System.out.println("Your balance is $"+balance); //Will print Your balance is $0.00
        //Does the sun rise from the west?
        boolean ans = false;
        System.out.println("The sun rises from the west. This statement is "+ans+"!"); //Will print The sun rises from the west. This statement is false!
        //My initials
        char firstIn = 'N';
        char lastIn = 'S';
        System.out.println("My initials are "+firstIn+"."+lastIn+"."); //Will print My initials are N.S.
    }
}


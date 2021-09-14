/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;
import java.util.Scanner;
/**
 *
 * @author Norralak
 */
public class Customer extends Account{
    private final String user;
    private String pass;
    private final String name; 
    private final String socSec; 
    protected String phNum; 
    protected String city;
    protected int numOfAcc;
    protected final Account[] acc = new Account[5];

    public Customer(String user, String pass, String name, String socSec, String phNum) {
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.socSec = socSec;
        this.phNum = phNum;
        this.numOfAcc = 0;
        this.acc[0] = new Account();
        this.acc[1] = new Account();
        this.acc[2] = new Account();
        this.acc[3] = new Account();
        this.acc[4] = new Account();
        Bank.database[Bank.cusCount] = this;
        Bank.cusCount++;
    }
    
    public Customer(String user, String pass, String name, String socSec, String phNum, String city) {
        this.user = user;
        this.pass = pass;
        this.name = name.toUpperCase();
        this.socSec = socSec;
        this.phNum = phNum;
        this.numOfAcc = 0;
        this.city = city.toUpperCase();
        this.acc[0] = new Account();
        this.acc[1] = new Account();
        this.acc[2] = new Account();
        this.acc[3] = new Account();
        this.acc[4] = new Account();
        Bank.database[Bank.cusCount] = this;
        Bank.cusCount++;
    }
    
    public Customer(){
        boolean uExists = true;
        Scanner input = new Scanner(System.in);
        System.out.println("****----    REGISTRATION    ----****");
        System.out.print("ENTER YOUR NAME: ");
        name = input.nextLine();
        System.out.print("CREATE A USERNAME: ");
        String userName = input.nextLine();
        while (uExists){
            uExists = false;
            for (int i = 0; i < Bank.cusCount; i++){
                if (Bank.database[i].getUser().equals(userName)){
                    uExists = true;
                    System.out.println("USERNAME EXISTS, PLEASE ENTER A NEW USERNAME: ");
                    userName = input.nextLine();
                    break;
                }
            }
        }
        user = userName;
        System.out.println("ENTER A PASSWORD (NO SPACES PERMITTED): ");
        pass = input.next();
        input.nextLine();
        System.out.println("ENTER YOUR SOCIAL SECURITY NUMBER: ");
        socSec = input.nextLine();
        System.out.println("ENTER YOUR PHONE NUMBER: ");
        phNum = input.nextLine();
        System.out.println("ENTER YOUR CITY (OPTIONAL): ");
        city = input.nextLine();
        numOfAcc = 0;
        System.out.println("THANK YOU "+name+". YOUR PROFILE HAS BEEN CREATED.");
        Bank.database[Bank.cusCount] = this;
        Bank.cusCount++;
        this.acc[0] = new Account();
        this.acc[1] = new Account();
        this.acc[2] = new Account();
        this.acc[3] = new Account();
        this.acc[4] = new Account();
    }
    
    protected void updateProfile(String fieldName, String newVal){
        switch (fieldName.toUpperCase()){
            case "PASSWORD":
                pass = newVal;
                break;
                
            case "CITY":
                city = newVal.toUpperCase();
                break;
            
            case "PHONE NUMBER":
                phNum = newVal;
                
            default:
                System.out.println("THE ENTERED FIELD CANNOT BE CHANGED OR DOES NOT EXIST.");
                break;
        }
    }
    
    protected void showProfile(){
        System.out.println("NAME: "+name);
        System.out.println("PHONE NUMBER: "+phNum);
        System.out.println("CITY: "+city);
        System.out.println("ACCOUNTS OPENED: "+numOfAcc);
    }
    
    protected Account openAccount(){
        if (numOfAcc < 5){
            super.openAccount(acc[numOfAcc]);
            numOfAcc++;
            return acc[numOfAcc - 1];
        }
        else {
            System.out.println("YOU ALREADY HAVE 5 ACCOUNTS");
            this.showProfile();
            return acc[numOfAcc - 1];
        }
    }
    
    protected void getBankBalance(int accIndex){
        this.acc[accIndex].showBalance();
    }
    
    protected void getBankBalance(){

        for (Account account : this.acc){
            account.showBalance();
        }
    }
    
    public String getUser(){
        return user;
    }
    
    public String getPass(){
        return pass;
    }
    
    public String getName(){
        return name;
    }
    
}

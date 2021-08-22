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
    private String phNum; 
    private String city;
    private int numOfAcc;
    private final Account[] acc = new Account[5];

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
        this.name = name;
        this.socSec = socSec;
        this.phNum = phNum;
        this.numOfAcc = 0;
        this.city = city;
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
            for (int i = 0; i <= Bank.cusCount; i++){
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
    }
    
    private void updateProfile(String fieldName, String newVal){
        switch (fieldName.toUpperCase()){
            case "PASSWORD":
                pass = newVal;
                break;
                
            case "CITY":
                city = newVal;
                break;
            
            case "PHONE NUMBER":
                phNum = newVal;
                
            default:
                System.out.println("THE ENTERED FIELD CANNOT BE CHANGED OR DOES NOT EXIST.");
                break;
        }
    }
    
    private void showProfile(){
        System.out.println("NAME: "+name.toUpperCase());
        System.out.println("PHONE NUMBER: "+phNum.toUpperCase());
        System.out.println("CITY: "+city.toUpperCase());
        System.out.println("ACCOUNTS OPENED: "+numOfAcc);
    }
    
    protected Account openAccount(){
        acc[numOfAcc] = super.openAccount();
        numOfAcc++;
        return acc[numOfAcc - 1];
    }
    
    private void getBankBalance(int accIndex){
        this.acc[accIndex].showBalance();
    }
    
    private void getBankBalance(){
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
}

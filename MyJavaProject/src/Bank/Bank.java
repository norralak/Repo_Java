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
public class Bank {
    public static Scanner input = new Scanner(System.in);
    public static int nCrypted = 26012542;
    public static Customer[] database = new Customer[1000];
    public static int cusCount = 0;
    
    public static void menu (){
        int run = 13;
        while (run == 13){
            System.out.println("WELCOME \n"
                    + "PRESS 1 TO LOGIN \n"
                    + "PRESS 2 TO SIGN UP \n"
                    + "PRESS 3 TO EXIT \n"
                    + ": ");
            int choice = input.nextInt();
            input.nextLine();          
            switch (choice){
                case 1:
                    System.out.println("ENTER YOUR USERNAME: ");
                    String userName = input.nextLine();
                    logIn(userName);
                    break;
                
                case 2:
                    database[cusCount] = new Customer();
                    break;
                    
                case 3: 
                    System.out.println("THANK YOU!");
                            
                    run = -13;
                    break;
                   
                default:
                    System.out.println("PLEASE ENTER A VALID CHOICE. RELOADING MENU...");
                    break;
            }
        }
    }
    
    public static void logIn(String userName){
        boolean foundUser = false;
        for (int i = 0; i < cusCount; i++){
            if (database[i].getUser().equals(userName)){
                foundUser = true;
                System.out.println("ENTER YOUR PASSWORD: ");
                String passWord = input.nextLine();
                if (database[i].getPass().equals(passWord)){
                    int loop = 13;
                    while (loop == 13){
                        System.out.println("HELLO!");
                        database[i].showProfile();
                        System.out.println("WHAT WOULD YOU LIKE TO DO? \n"
                                + "PRESS 1 TO VIEW ACCOUNT BALANCES \n"
                                + "PRESS 2 DEPOSIT / MAKE A PAYMENT \n"
                                + "PRESS 3 WITHDRAW \n"
                                + "PRESS 4 TO UPDATE PROFILE \n"
                                + "PRESS 5 TO OPEN A NEW ACCOUNT \n"
                                + "PRESS 0 TO EXIT \n"
                                + ": ");
                        int choice = input.nextInt();
                        input.nextLine();
                        switch (choice){
                            case 1:
                                database[i].getBankBalance();
                                break;
                            
                            case 2:
                                boolean found = false;
                                System.out.println("PLEASE ENTER YOUR ACCOUNT NUMBER: ");
                                int num = input.nextInt();
                                input.nextLine();
                                for (int j = 0; j < database[i].numOfAcc ; j++){
                                    if (database[i].acc[j].getId() == num){
                                        found = true;
                                        database[i].acc[j].showBalance();
                                        System.out.println("ENTER HOW MUCH WOULD YOU LIKE TO DEPOSIT3"
                                                + "/PAY: ");
                                        double moneyIn = input.nextDouble();
                                        input.nextLine();
                                        database[i].acc[j].makeDeposit(moneyIn);
                                        break;
                                    }
                                }   
                                if (!found){
                                    System.out.println("ACCOUNT NUMBER NOT FOUND, RETURNING TO MENU.");
                                }
                                break;
                            
                            case 3:
                                found = false;
                                System.out.println("PLEASE ENTER YOUR ACCOUNT NUMBER: ");
                                num = input.nextInt();
                                input.nextLine();
                                for (int j = 0; j < database[i].numOfAcc; j++){
                                    if (database[i].acc[j].getId() == num){
                                        found = true;
                                        database[i].acc[j].showBalance();
                                        input.nextLine();
                                        System.out.println("ENTER HOW MUCH WOULD YOU LIKE TO WITHDRAW/CHARGE: ");
                                        double moneyOut = input.nextDouble();
                                        input.nextLine();
                                        database[i].acc[j].makeWithdrawal(moneyOut);
                                        break;
                                    }
                                }
                                if (!found){
                                    System.out.println("ACCOUNT NUMBER NOT FOUND, RETURNING TO MENU.");
                                }
                                break;
                            
                            case 4:
                                System.out.println("PLEASE ENTER THE FIELD YOU WANT TO UPDATE. \n"
                                        + "PASSWORD \n"
                                        + "CITY \n"
                                        + "PHONE NUMBER \n"
                                        + ": ");
                                        String fieldName = input.nextLine();
                                        System.out.println("ENTER A NEW VALUE FOR YOUR "+fieldName.toUpperCase());
                                        String newVal = input.nextLine();
                                        database[i].updateProfile(fieldName, newVal);
                                        break;
                        
                            case 5:
                                database[i].openAccount();
                                break;
                                
                            case 0:
                                System.out.println("THANK YOU!");
                                loop = -13;
                                break;
                            
                            default:
                                System.out.println("INVALID RESPONSE, RETURNING TO MENU.");
                                break;
                            
                        }
                    }
                }
                
                else {
                    System.out.println("INCORRECT PASSWORD. RETURNING TO MENU...");
                    break;
                }
                
            }
        }
        
        if (!foundUser){
            System.out.println("USERNAME NOT FOUND. RETURNING TO MENU...");
        }
        
    }
    
    public static void main (String[] args){
        Customer norralak = new Customer("NORRALAK","KALARRON","NORRALAK SUKARAM", "131-313-1313", "(877) 393 4448");
        menu();
    }
    
}

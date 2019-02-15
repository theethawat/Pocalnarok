/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author theet
 */
import java.util.*;
public class Bag {
    int money;
    private Scanner reader;
    private Random randomNumber;
    
    public Bag(int userMoney){
        money = userMoney;
        reader = new Scanner (System.in);
        randomNumber = new Random();
    }
    public void selectAddMoneyMethod(Bag userBag){
        int inputMethod;
        System.out.println("Please Enter the Method that you want to Add Money");
        System.out.println("Integer Input Only 1) Paid Money from Cash Card 2) Random Me money");
        inputMethod = reader.nextInt();
        if(inputMethod == 1){
            creditAddMoney(userBag);
        }
        if(inputMethod == 2){
            randomAddMoney(userBag);
        }
        else{
            System.out.println("Please Input only 1 and 2");
        }
    }
    public Bag creditAddMoney(Bag userBag){
        int moneyInput;
        double serialNo;
        System.out.println("Add your Money that you want to input:");
        moneyInput = reader.nextInt();
        System.out.println("Add your Serial Number from Cash Card");
        serialNo = reader.nextDouble();
        if(serialNo == 22052557){
            userBag.money = userBag.money + moneyInput ;
            System.out.println("Your Adding Success");
        }
        else{
            System.out.println("Sorry you add an wrong Serial Number");
        }
        return userBag;
    }
    public Bag randomAddMoney(Bag userBag){
        int randomMoney;
        randomMoney = randomNumber.nextInt(500);
        System.out.println("You got " + randomMoney +" from the random");
        userBag.money = userBag.money + randomMoney ;
        System.out.println("Your Adding Success");
        return userBag;
    }
}

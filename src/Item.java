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
public class Item {
    
    private ItemStructure tank;
    private ItemStructure podium;
    private ItemStructure submarine;
    private ItemStructure  standy;
    private Scanner read = new Scanner (System.in);
   public Item(){
       tank = new ItemStructure(30,1,450);
       podium = new ItemStructure(10,1,100);
       submarine = new ItemStructure(50,0,1000);
       standy = new ItemStructure(15,3,100);
   }
   
   public Novice buyTank(Item itemCollection, Novice customer){
       if(customer.pocket.money >=itemCollection.tank.price ){
           System.out.println("You Can buy Tank ");
           customer.pocket.money = customer.pocket.money - itemCollection.tank.price;
           customer.itemLog.tank.amount = customer.itemLog.tank.amount +1;
           System.out.println("Buy Success thank you for coming");
       }
       return customer;
   }
    /*
   For Buy Podium Submarine Standy 
   Coming soon
   */
   public void whatBuy(Novice customer){
       System.out.println("Hello Welcome To Item Shop --- Please Select Item that you want");
       System.out.println("Only Integer accepted");
       System.out.println("1)Tank  2)Podium(Coming soon)  3)Submarine(Coming soon)  4)Standy(Coming soon) ");
       int selecting = read.nextInt();
       Item stock = new Item();
       if(selecting == 1){
           customer = buyTank(stock,customer);
       }
       else{
           System.out.println("Sorry We don't have this item for you");
       }
   }
}


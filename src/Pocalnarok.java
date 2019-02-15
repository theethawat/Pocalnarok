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
public class Pocalnarok {
    //Field
    private Scanner reader;

    private Novice gamePlayerNovice;
    private String  gamePlayerName;
    
    //Constructor    
    public Pocalnarok(){
        reader = new Scanner (System.in);
    }
    
    //Method
    public String inputSelecting(){
        String inputChoice = reader.nextLine();
        return inputChoice.trim();
    }
    
    public String inputName(){
        String nameInput = reader.nextLine();
        return nameInput.trim();
    }
    
    public int startControl(Novice player, Bag userBag){
     
        System.out.println("Selecting the thing that you want to do");
        System.out.println("A) Add Money  B) Buy Item  C) Kill  D) Viewinfo E) Exit");
        System.out.println(">>");
        
        //Selecting Activity
        String inputValue = inputSelecting();
        if(inputValue.startsWith("A")){
          System.out.println("You Select Add Money");
          userBag.selectAddMoneyMethod(userBag);
        }
        else if(inputValue.startsWith("B")){
          System.out.println("You Select Buy Item");  
          player.itemLog.whatBuy(player);
        }
        else if(inputValue.startsWith("C")){
          System.out.println("You Select Kill");   
        }
        else if(inputValue.startsWith("D")){
            System.out.println("You Select View Info"); 
            player.monitor(player);
        }
        else if(inputValue.startsWith("E")){
            System.out.println("You Select Exit"); 
            System.exit(0);
        }
        else{
            System.out.println("Please type only A, B , C , D,E");
        }
        return 0;
    }
    
    
       
    public static void main(String args[]) {
        int gameStatusReturn;
        System.out.println("Game Start");
        //Input Name
        System.out.println("Enter Your Name of Novice:");
        Pocalnarok gameUser = new Pocalnarok();
        gameUser.gamePlayerName = gameUser.inputName();
        System.out.println("Your Name is "+gameUser.gamePlayerName);
        
         //Create Bag
        Bag userBag = new Bag(1000);
         
        //Createitem
        Item itempocket = new Item();
        //Create Novice
        Novice player = new Novice(100,gameUser.gamePlayerName,userBag,itempocket);
        int i=1;
        // Call Initail Value to start Games
        player.startGame(player.health,userBag);
        do{
           gameStatusReturn =  gameUser.startControl(player,userBag);
        }
        while(gameStatusReturn == 0);
    }
}

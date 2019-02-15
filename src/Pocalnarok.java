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
    private Scanner gameSelectionScanner;
    private Scanner gamePlayerNameScanner;
    private Novice gamePlayerNovice;
    private String  gamePlayerName;
    
    //Constructor    
    public Pocalnarok(){
        gameSelectionScanner = new Scanner (System.in);
        gamePlayerNameScanner = new Scanner(System.in);
    }
    
    
    //Method
    public String inputSelecting(){
        String inputChoice = gameSelectionScanner.nextLine();
        return inputChoice.trim();
    }
    
    public String inputName(){
        String nameInput = gamePlayerNameScanner.nextLine();
        return nameInput.trim();
    }
    
    public void startControl(Novice player){
        System.out.println("Selecting the thing that you want to do");
        System.out.println("A) Add Money  B) Buy Item  C) Kill  D) Viewinfo");
        System.out.println(">>");
        
        //Selecting Activity
        String inputValue = inputSelecting();
        if(inputValue.startsWith("A")){
          System.out.println("You Select Add Money");
        }
        else if(inputValue.startsWith("B")){
          System.out.println("You Select Buy Item");  
        }
        else if(inputValue.startsWith("C")){
          System.out.println("You Select Kill");   
        }
        else if(inputValue.startsWith("D")){
            System.out.println("You Select View Info"); 
            player.monitor(player);
        }
        else{
            System.out.println("Please type only A, B , C , D");
        }
    }
    
    
    
    public static void main(String args[]) {
        System.out.println("Game Start");
        //Input Name
        System.out.println("Enter Your Name of Novice:");
        Pocalnarok gameUser = new Pocalnarok();
        gameUser.gamePlayerName = gameUser.inputName();
        System.out.println("Your Name is "+gameUser.gamePlayerName);
        
         //Create Bag
        Bag userBag = new Bag(1000);
         
        //Create Novice
        Novice player = new Novice(100,gameUser.gamePlayerName,userBag.money);
        int i=1;
        // Call Initail Value to start Games
        player.startGame(player.health,player.money);
        
        gameUser.startControl(player);
    }
}

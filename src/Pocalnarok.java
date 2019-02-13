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
    private Scanner gameSelection;
    
    
    //Constructor    
    public Pocalnarok(){
        gameSelection = new Scanner (System.in);
    }
    
    
    //Method
    public String inputSelecting(){
        String inputChoice = gameSelection.nextLine();
        return inputChoice.trim();
    }
    
    public void startControl(){
        System.out.println("Selecting the thing that you want to do");
        System.out.println("A) Add Money  B) Buy Item  C) Kill  D) Viewinfo");
        System.out.println(">>");
        //Selecting Activity
        String inputValue = inputSelecting();
        /*For Debug
        System.out.println(inputValue);
        */
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
        }
        else{
            System.out.println("Please type only A, B , C , D");
        }
    }
    
    public static void main(String args[]) {
        System.out.println("Game Start");
        //Create Novice
        Novice player = new Novice(100);
        int i=1;
        // Call Initail Value to start Games
        player.startGame(player.health,player.money);
        Pocalnarok gameControl = new Pocalnarok();
        gameControl.startControl();
    }
}

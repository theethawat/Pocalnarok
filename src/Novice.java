//import java.io.*;

/*From Old Novice Class */
public class Novice {

    // Field
    private int attract;
    int health;
    Bag pocket;
    private int exp;
    private String noviceName;
    Object Novice;

    // Constructor
    public Novice(int initialHealth,String name,Bag initialMoney) {
        health = initialHealth;
        attract = 25;
        pocket = initialMoney;
        exp = 0;
        noviceName = name;
    }

    // Method
    public void startGame(int initHealth,Bag initMoney) {
        System.out.println("----------------------------");
        System.out.println("Game Start Please Selected the Method");
        System.out.println("Your Health now is : " + initHealth +" Your Money is now:"+initMoney.money);
    }

    public Novice killing(Novice killer) {
        System.out.println("Your Power/Health is: " + killer.health);
        if (killer.health > 0) {
            killer.exp = killer.exp + 10;
            killer.attract = killer.attract + 25;
            System.out.println("#### You are Killing ####");
            System.out.println("---Congratulation You got 10 exp  and 25 Attract for this Activity ---");
        } else {
            System.out.println("Your cannot kill him you don't have a power !");
        }
        return killer;
    }

    public Novice beated(Novice victim) {
        victim.health = victim.health - 25;
        victim.exp = victim.exp + 10;
        System.out.println("#### You have Killed ####");
        return victim;
    }

    public void monitor(Novice info) {
        System.out.println("----------------------------");
        System.out.println("Your Infomation now");
        System.out.println("Your Health now is : " + info.health);
        System.out.println("Your Attract now is : " + info.attract);
        System.out.println("Your Exp now is : " + info.exp);
        System.out.println("Your Money is:"+info.pocket.money);
        System.out.println("----------------------------");
    }

    
}
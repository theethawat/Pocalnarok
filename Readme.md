# Java Ragnarok Homework - Pocalnarok
[![CircleCI](https://circleci.com/gh/theethawat/Pocalnarok.svg?style=svg)](https://circleci.com/gh/theethawat/Pocalnarok)

Theethawat Savastham 5910110150 https://github.com/theethawat

Language : Java SE 8 Oracle (Only Practice For Beginner)      IDE: Apache NetBeans IDE 10.0
 # โครงสร้างของเกม
## Class Pocalnarok 
เป็นคลาสสำคัญในการจัดการกระบวนการต่างๆ ของเกม ได้แก่ ป้อนชื่อผู้ใช้ และ สร้างเรียกใช้ หรือ `new` สิ่งใหม่ๆ ออกมา
รวมถึงเรียก Method   `inputControl` เพื่อใช้ควบคุมเกม โดย inputControl จะโผล่มาเรื่อยๆ หลังจาก จบเกมแต่ละคำสั่ง
ก็จะเข้าสู่ Method Main เพื่อเช็คว่า Method Control Return ค่าเป็น 0 หรือไม่ ถ้าใช่ ก็ให้ทำต่อ 
### รับค่าจากใน Scanner 
จะใส่ไว้ในช่วงประกาศตัวแปรข้างบน Class และ/หรือ ช่วง initial ค่าให้ class (Constructor) โดยเรียกผ่าน `import java.util.*;`
Scanner เป็น Class ดังนั้นมันก็เหมือนเราเรียก Class มาใช้ คล้ายๆ กับมันเป็น ตัวแปรชนิดหนึ่ง แต่ต้อง `new` ขึ้นมา คล้ายๆ เป็น
Structure ชนิดหนึ่ง เราประกาศครั้งหนึ่งต่อไฟล์ แล้ว เราสามารถนำตัวแปรนั้นไปใช้ได้ทั้งไฟล์
```
 private Scanner reader;
 public Pocalnarok(){
        reader = new Scanner (System.in);
    }
```
หรือ สามารถใช้อีกวิธีหนึ่งที่ได้ผลเหมือนกัน
```
private Scanner reader = new Scanner (System.in);
```
### Main Method
```
public static void main(String args[]) {
        int gameStatusReturn;
        System.out.println("Game Start");
        
        System.out.println("Enter Your Name of Novice:");  //Input Name
        Pocalnarok gameUser = new Pocalnarok();
        gameUser.gamePlayerName = gameUser.inputName();
        System.out.println("Your Name is "+gameUser.gamePlayerName);
        
        Bag userBag = new Bag(1000);  //Create Bag
        
        Item itempocket = new Item();  //Create Item
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
```
จะเห็นว่ามีการเรียกใช้ทุกส่วนของโปรแกรม เรียกใช้ Class ต่างๆ ทั้งหมด ใน Method Main นี้ และเราจะเก็บค่าพวกนี้เข้าไปใน Novice ดังโค้ด
```
 Novice player = new Novice(100,gameUser.gamePlayerName,userBag,itempocket);
```
เนื่องจาก Class Novice เหมือนเป็นตัวละครหลัก จะเก็บทั้งหมด ทั้งชื่อ User กระเป๋าเงิน และ กระเป๋าไอเท่ม
 เวลาเรียกใช้ อาจจะต้องเรียกในแบบใช้ .ไปเรื่อยๆ ตามที่ IDE บอก
### Controller And Selecting
```
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
          player.killing(player);
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
```
การทำงานสามารถเรียกค่าข้าม Class ได้ โดยผ่านตัวแปล เช่น `player` ที่เป็น Class หรือ คล้ายๆ Structure แบบ Novice
ก็สามารถเอาไปเรียก Method จาก Class อื่นๆ ได้ โดยไฟล์นี้ Class ทั้งหมดยังเป็น Public และ Method ทั้งหมด เป็น Public 
(ยกเว้น Class หรือ Method ที่อยู่ใน Library ที่เรียกมาใช้)

## Case Study - Bag Class กระเป๋าสตางค์
```
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
```

Source Code อยู่ใน .src ทั้งหมดเป็นเพียงสรุปตามความเข้าใจหลังจากการทำงาน อาจจะมีการผิด Concept บ้าง ไม่สามารถใช้เป็นแหล่งอ้างอิงได้ครับ

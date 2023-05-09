import java.util.Scanner;
//import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.*;   

  class Player{
  int health;
  int damage;
  int Xpos;
  int Ypos;
  public Player()
  {
    health = 10;
    damage = 5;
    Xpos = 4;
    Ypos = 5;
  }
  public int getXpos(){return Xpos;}
  public int getYpos(){return Ypos;}
  public int getHealth(){return health;}
  public void setXpos(int newXpos){Xpos= newXpos;}
  public void setYpos(int newYpos){Ypos= newYpos;}
  public void setHealth(int newHP){health = newHP;
  if (health >= 0) {}}
}
class Monster{
  int monXpos;
  int monYpos;
  int monHealth;
  boolean isDead;
  public Monster(int x, int y)
  {
    monXpos = x;
    monYpos = y;
    isDead = false;
    monHealth = 10;
  }
  public boolean getDead()
  {return isDead;}
  public void hit(int dmg)
  {
    monHealth -= dmg;
    if(isDead != true){
    System.out.println("You did " + dmg + " damage to the Slime!");
  }
  if(monHealth == 0){isDead = true;System.out.println("You Killed the Monster!");System.out.println("Picked up green key!");}}}

class Thing{
  int thingXpos = 0;
  int thingYpos = 0;
  boolean owned;
  public Thing(int theX, int theY)
  {
    thingXpos = theX;
    thingYpos = theY;
    owned = false;
  }
  public int getXpos(){return thingXpos;}
  public int getYpos(){return thingYpos;}
  public boolean returnOwned(){return owned;}
  public void Own(){owned = true;}
}

class Key extends Thing{
  public Key(String color, int keyX, int keyY)
  {
    super(keyX, keyY);
    String KeyColor = color;
  }
  public boolean returnOwned(){return super.returnOwned();}
  public int getXpos(){return super.getXpos();}
  public int getYpos(){return super.getYpos();}
}

class Potion extends Thing{
  public Potion(String type, int potX, int potY)
  {
    super(potX, potY);
    String potName = type;
  }
 
  public boolean returnOwned(){return super.returnOwned();}
  public int getXpos(){return super.getXpos();}
  public int getYpos(){return super.getYpos();}
}

public class Main {
public static void main(String[] args) {

Scanner scan = new Scanner(System.in);
boolean restart = false;
Player Character = new Player();
Thing redKey = new Key("Red", 1, 1);
Monster Slime = new Monster(7, 8);
Thing healPot = new Potion("heal",(int)(Math.random()*2) + 4, (int)(Math.random()*3) + 4);
  //(int)(Math.random()*2) + 4, (int)(Math.random()*3) + 4
Thing greenKey = new Key("Green", 7, 7);
    
    String command = "";
    boolean isU = false;
    boolean isD = false;
    boolean isL = false;
    boolean isR = false;
    boolean isMon = false;
    boolean isE = false;
    boolean isQ = false;
    boolean inputCorrect = false;
    int initX = Character.getXpos();
    int initY = Character.getYpos();

ArrayList<Thing> Inventory = new ArrayList<Thing>();
String[][] Map = {
  
    {"W","W","W","W","W","W","G","W","W","W"},
    {"W","RK","O","O","W","W","O","O","O","W"},
    {"W","O","W","O","W","W","W","W","O","W"},
    {"W","O","O","O","O","O","O","O","O","W"},
    {"W","W","O","O","O","O","O","W","W","W"},
    {"W","W","O","O","O","O","O","W","W","W"},
    {"W","W","O","O","O","O","O","O","O","W"},
    {"W","O","O","O","O","O","W","W","R","W"},
    {"W","O","W","W","W","W","W","S","O","W"},
    {"W","O","O","O","P","W","W","O","O","W"},
    {"W","W","W","W","W","W","W","W","W","W"}
};

//////////////////////////////////
  try{
UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
  }
  catch(Exception e){ } 
  JFrame f=new JFrame("Adventure Game");
  Board b = new Board(f, Map);
  
//////////////////////////////////
  /*Square[][] Grid = new Square[11][10];*/
  /*for (int row = 0; row < 11; row++)
    {for (int col = 0; col < 10; col++)
    {Grid[row][col] = new Square(Map[row][col], row, col);}}*/
    //game part/////
  
    //System.out.println();
    b.movePlayer(initX, initY, Character.getXpos(), Character.getYpos());
    
while (restart==false)
  { //fix later for correct text
    //System.out.println(""+Character.getYpos() + " " + Character.getXpos());
    initX = Character.getXpos();
    initY = Character.getYpos();
    if(Map[Character.getYpos()][Character.getXpos()] == "S" && Slime.getDead() != true){isMon = true;if (Slime.getDead() == false){isU=false;isL=false;isR=false;isD=false;}}
    else{
    if(Map[Character.getYpos()-1][Character.getXpos()] != "W")
    {System.out.print("Up, ");isU=true;}
    if(Map[Character.getYpos()+1][Character.getXpos()] != "W")
    {System.out.print("Down, ");isD=true;}
    if(Map[Character.getYpos()][Character.getXpos()-1] != "W")
    {System.out.print("Left, ");isL=true;}
    if(Map[Character.getYpos()][Character.getXpos()+1] != "W")
     {System.out.println("Right.");isR=true;}
    }
      
    if((Slime.getDead() == false) && (isMon == true))
    {
      System.out.print("Select Q to attack.");isQ=true;
      if (healPot.returnOwned() == true)
      {System.out.print("Select E to drink a potion ");isE=true;}
    }
    
    while (inputCorrect == false)
      {
        command = scan.nextLine(); 
        if((command.equals("W") || command.equals("w"))&&isU){inputCorrect = true;}
        else if((command.equals("A") || command.equals("a"))&&isL){inputCorrect = true;}
        else if((command.equals("S") || command.equals("s"))&&isD){inputCorrect = true;}
        else if((command.equals("D") || command.equals("d"))&&isR){inputCorrect = true;}
        else if((command.equals("E") || command.equals("e")) && isE){inputCorrect = true;}
        else if((command.equals("Q") || command.equals("q")) && Map[Character.getYpos()][Character.getXpos()].equals("S")){inputCorrect = true;}
        else if(command.equals("Q")){inputCorrect = true;}
        else if(command.equals("R")){inputCorrect = true;}
        if (inputCorrect == false){System.out.println("input not recognized. Please try again.");}
        //else {System.out.println("moving " + command);}
      }
    if((command.equals("W") || command.equals("w"))&&isU == true){Character.setYpos(Character.getYpos()-1);}
    if((command.equals("A") || command.equals("a"))&&isL == true){Character.setXpos(Character.getXpos()-1);}
    if((command.equals("S") || command.equals("s"))&&isD == true){Character.setYpos(Character.getYpos()+1);}
    if((command.equals("D") || command.equals("d"))&&isR == true){Character.setXpos(Character.getXpos()+1);}
    if((Character.getYpos()==redKey.getYpos()) && (Character.getXpos()==redKey.getXpos()) && redKey.returnOwned() == false){redKey.Own();System.out.println("Picked up red key!");}
    if((Character.getYpos()==greenKey.getYpos()) && (Character.getXpos()==greenKey.getXpos()) && greenKey.returnOwned() == false){greenKey.Own();System.out.println("Picked up green key!");}
    if((Character.getYpos()==healPot.getYpos()) && (Character.getXpos()==healPot.getXpos()) && healPot.returnOwned() == false){healPot.Own();System.out.println("Picked up health potion!");}
    
    if(command.equals("E") || command.equals("e")){/*potion command goes here*/
Character.setHealth(10);Character.setHealth(Character.getHealth()-4);}
    if((command.equals("Q")) || (command.equals("q")))
{Slime.hit(2);Character.setHealth(Character.getHealth()-4);b.newHP(Character.getHealth());}
    if((command.equals("R")) || (command.equals("r")))
       {restart = true;}
    if (Map[Character.getYpos()][Character.getXpos()] == "R")
    {if (redKey.returnOwned()){System.out.println("Red gate opened using red key."); b.unlockDoor(7, 8);
     if ((redKey.getXpos() == 0 || redKey.getXpos() == 9) || (redKey.getYpos() == 0 || redKey.getYpos() == 10))
     {System.out.print("You win!");System.exit(0);}}
    else{System.out.println("A red key is needed to open this red Gate!");Character.setYpos(initY);Character.setXpos(initX);}}
    if (Map[Character.getYpos()][Character.getXpos()] == "G")
    {if (greenKey.returnOwned() || Slime.getDead() == true){System.out.println("Green gate opened using green key."); b.unlockDoor(greenKey.getXpos(), greenKey.getYpos());          
     if ((Character.getXpos() == 0 || Character.getXpos() == 9) || (Character.getYpos() == 0 || Character.getYpos() == 10))
     {System.out.print("You win!");System.exit(0);}}
     else{System.out.println("A green key is needed to open this green Gate!");Character.setYpos(initY);Character.setXpos(initX);
        }
    }

    b.movePlayer(initX, initY, Character.getXpos(), Character.getYpos());

isU=false;isL=false;isR=false;isD=false;isMon=false;isE=false;isQ=false;inputCorrect = false;
  }
  System.exit(0);
  }
}
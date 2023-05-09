import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Board {
  private Square[][] squares;
  private Square textBox;
  //private Square inventory;
  private Square healthbar;
  public Board(JFrame f, String[][] copyString) {

    textBox = new Square (f, 20, 275, "text");
    //inventory = new Square (f, 300, 50, "inv");
    healthbar = new Square (f, 300, 50, "health");
    
    squares = new Square[11][10];
    // creating one Square object with default size 50 x 50
    for (int row = 0; row < 11; row++) {
      for (int col = 0; col < 10; col++) {
        squares[row][col] = new Square(f, col * 28, row * 22, copyString[row][col]);
      }
    }

    // keep these commands at the end of the Board constructor to properly display the jFrame
    f.setSize(400, 400);
    f.setLayout(null);
    f.setVisible(true);
  }

public void newHP(int hp){healthbar.setNewText("" + hp);}
  
  public void movePlayer(int initx, int inity, int newx, int newy) {
    squares[inity][initx].setNewText("");
    squares[newy][newx].setNewText("P");
  }
  
  public void unlockDoor(int x, int y)
      {squares[x][y].unlockDoor();} 
}
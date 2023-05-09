import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.*;

public class Square {

private JButton b;
  
  public Square(JFrame f, int x, int y, String squaretype) {
    b = new JButton("");

    b.setFont(new Font("Impact", Font.PLAIN, 7));
    b.setBounds(x, y, 35, 29);  
    if(squaretype.equals("W"))
    {b.setBackground(Color.BLACK);}
    else if(squaretype.equals("R"))
    {b.setBackground(Color.RED);}
    else if(squaretype.equals("G"))
    {b.setBackground(Color.GREEN);}
    else if(squaretype.equals("RK"))
    {b.setText("K");}
    else if(squaretype.equals("S"))
    {b.setText("M");}
    else if(squaretype.equals("P"))
    {b.setText("H");}
    else if(squaretype.equals("text"))
    {b.setText("\n\nMove up, left, right, and down with WASD. \n\nE to pick up/use objects. R to restart.");
    b.setBounds(20, 275, 300, 60);}

    /*else if(squaretype.equals("inv"))
    {b.setText("Bag: ");
    b.setBounds(300, 50, 60, 60);}*/

    else if(squaretype.equals("health"))
    {b.setFont(new Font("Impact", Font.PLAIN, 24));
      b.setText("10");
    b.setBounds(300, 50, 70, 70);
    }
    
    f.add(b); // add the button to the jFrame
  }

public void setNewText(String newString)
  {b.setText(newString);}

  //public void setInv(String newItem)
  //{b.setText("Bag: \n" + newItem);}

public void unlockDoor()
  {b.setBackground(Color.WHITE);}
}
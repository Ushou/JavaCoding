import java.awt.*;
import javax.swing.*;

public class Main{
  
  public static void main(String args[]){
     JFrame frame=new JFrame("Title");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //視窗可視和可關閉化
        JLable lable=new Jlabel("Hey You!");  
        JPanle panel=new JPanel();
        panel.add(label);
        panel.setLayout(null);
        labeal.setBounds(200,50,100,100);
        frame.getContentPane().add(panel);   
        frame.setSize(500,500);
        frame.setLocation(400,250);
  }
}

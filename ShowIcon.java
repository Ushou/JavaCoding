import java.awt.*;
import javax.swing.*;

public class Main{
  
  public static void main(String args[]){
    JFrame frame=new JFrame("Title");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //視窗可視和可關閉化
    Icon icon=new ImageIcon("Icon.jpg");
    JLable lable=new Jlabel(icon);  
    JPanle panel=new JPanel();
    panel.add(label);
    panel.setLayout(null);
    labeal.setBounds(0,0,1920,1080);
    frame.getContentPane().add(panel);   
    frame.setSize(500,500);
    frame.setLocation(400,250);
  }

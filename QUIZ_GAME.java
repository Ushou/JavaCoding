package Pack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Game {
	public int currect=0;
	String position;
	JFrame frame;
	JPanel TitlePanel,StartPanel,PlayerPanel,QuestionPanel,ChoicePanel,EndPanel;
	JLabel TitleLabel,PlayerLabel,NameLabel,TotalLabel,CurrectLabel;
	JButton StartButton,CButtonOne,CButtonTwo,CButtonThree,CButtonFour,EndButton;
	JTextArea TextArea;
	Container con;
	Font titleFont = new Font("Times new Roman",Font.PLAIN,80);
	Font normalFont = new Font("微軟正黑體",Font.PLAIN,30);
	StartHandler SHandler = new StartHandler();
	ChoiceHandler CHandler = new ChoiceHandler();
	GameEndHandler GEHandler = new GameEndHandler();
	
	public static void main(String args[]) {
		new Game();
	}
	
	public Game() {
		frame = new JFrame("QUIZ_GAME");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = frame.getContentPane();
		
		TitlePanel = new JPanel();
		TitlePanel.setBounds(100,100,600,100);
		TitlePanel.setBackground(Color.BLACK);
		TitleLabel = new JLabel("QUIZ_GAME");
		TitleLabel.setBackground(Color.BLACK);
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setFont(titleFont);
		TitlePanel.add(TitleLabel);
		con.add(TitlePanel);
		
		StartPanel = new JPanel();
		StartPanel.setBounds(300,400,200,100);
		StartPanel.setBackground(Color.BLACK);
		StartButton = new JButton("開始遊戲");
		StartButton.setBackground(Color.BLACK);
		StartButton.setForeground(Color.WHITE);
		StartButton.setFont(normalFont);
		StartButton.setFocusPainted(false);
		StartButton.addActionListener(SHandler);
		StartPanel.add(StartButton);
		con.add(StartPanel);
		
	}
	public void MainGame() {
		TitlePanel.setVisible(false);
		StartPanel.setVisible(false);
		PlayerPanel = new JPanel();
		PlayerPanel.setBounds(100,20,600,50);
		PlayerPanel.setBackground(Color.BLACK);
		PlayerPanel.setLayout(new GridLayout(1,4));
		PlayerLabel = new JLabel("Player:");
		PlayerLabel.setForeground(Color.WHITE);
		PlayerLabel.setFont(normalFont);
		TotalLabel = new JLabel("總共4題");
		TotalLabel.setForeground(Color.WHITE);
		TotalLabel.setFont(normalFont);
		CurrectLabel = new JLabel("答對"+currect+"題");
		CurrectLabel.setForeground(Color.WHITE);
		CurrectLabel.setFont(normalFont);
		NameLabel = new JLabel();
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setFont(normalFont);
		PlayerPanel.add(PlayerLabel);
		PlayerPanel.add(NameLabel);
		PlayerPanel.add(TotalLabel);
		PlayerPanel.add(CurrectLabel);
		con.add(PlayerPanel);
		
		TextArea = new JTextArea();
		TextArea.setBounds(100,70,600,230);
		TextArea.setLineWrap(true);
		TextArea.setBackground(Color.BLACK);
		TextArea.setForeground(Color.WHITE);
		TextArea.setFont(normalFont);
		QuestionPanel =new JPanel();
		QuestionPanel.setBackground(Color.BLACK);
		QuestionPanel.setBounds(100,70,600,230);
		QuestionPanel.add(TextArea);
		con.add(QuestionPanel);
		
		CButtonOne = new JButton();
		CButtonOne.setBackground(Color.BLACK);
		CButtonOne.setForeground(Color.WHITE);
		CButtonOne.setFont(normalFont);
		CButtonOne.setFocusPainted(false);
		CButtonOne.addActionListener(CHandler);
		CButtonOne.setActionCommand("c1");
		CButtonTwo = new JButton();
		CButtonTwo.setBackground(Color.BLACK);
		CButtonTwo.setForeground(Color.WHITE);
		CButtonTwo.setFont(normalFont);
		CButtonTwo.setFocusPainted(false);
		CButtonTwo.addActionListener(CHandler);
		CButtonTwo.setActionCommand("c2");
		CButtonThree = new JButton();
		CButtonThree.setBackground(Color.BLACK);
		CButtonThree.setForeground(Color.WHITE);
		CButtonThree.setFont(normalFont);
		CButtonThree.setFocusPainted(false);
		CButtonThree.addActionListener(CHandler);
		CButtonThree.setActionCommand("c3");
		CButtonFour = new JButton();
		CButtonFour.setBackground(Color.BLACK);
		CButtonFour.setForeground(Color.WHITE);
		CButtonFour.setFont(normalFont);
		CButtonFour.setFocusPainted(false);
		CButtonFour.addActionListener(CHandler);
		CButtonFour.setActionCommand("c4");
		
		ChoicePanel = new JPanel();
		ChoicePanel.setBackground(Color.BLACK);
		ChoicePanel.setLayout(new GridLayout(4,1));
		ChoicePanel.setBounds(250,300,300,200);
		ChoicePanel.add(CButtonOne);
		ChoicePanel.add(CButtonTwo);
		ChoicePanel.add(CButtonThree);
		ChoicePanel.add(CButtonFour);
		con.add(ChoicePanel);
		
		PlayerSetup();
		FirstQuestion();
	}
	public class StartHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MainGame();
		}
	}
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String PlayerChoice = e.getActionCommand();
			switch(position) {
			case"FirstQuestion":
				switch(PlayerChoice) {
				case "c1":SecondQuestion(); break;
				case"c2":RightChoice();SecondQuestion();break;
				case "c3":SecondQuestion(); break;
				case "c4":SecondQuestion(); break;
				}
				break;
			case"SecondQuestion":
				switch(PlayerChoice){
				case"c1":RightChoice();ThirdQuestion();break;
				case"c2":ThirdQuestion();break;
				case"c3":ThirdQuestion();break;
				case"c4":ThirdQuestion();break;
				}
				break;
			case"ThirdQuestion":
				switch(PlayerChoice) {
				case"c1":RightChoice();FourthQuestion();break;
				case"c2":FourthQuestion();break;
				case"c3":FourthQuestion();break;
				case"c4":FourthQuestion();break;
				}
				break;
			case"FourthQuestion":
				switch(PlayerChoice) {
				case"c1":GameEnd();break;
				case"c2":GameEnd();break;
				case"c3":GameEnd();break;
				case"c4":RightChoice();GameEnd();break;
				}
				break;
			}
				
		}
	}
	public void PlayerSetup() {
		NameLabel.setText("Rushma");
	}
	public void FirstQuestion() {
		position = "FirstQuestion";
		TextArea.setText("問題1.\n「Big Apple」是哪一個城市的別稱?");
		CButtonOne.setText("巴黎");
		CButtonTwo.setText("紐約");
		CButtonThree.setText("矽谷");
		CButtonFour.setText("東京");
	}
	public void SecondQuestion() {
		position = "SecondQuestion";
		TextArea.setText("問題2.\n電影「失落的帝國」是以哪一個古文明作為背景拍攝的?");
		CButtonOne.setText("亞特蘭提斯");
		CButtonTwo.setText("波斯");
		CButtonThree.setText("馬雅");
		CButtonFour.setText("埃及");
	}
	public void ThirdQuestion() {
			position = "ThirdQuestion";
			TextArea.setText("問題3.\n日本著名的明治神宮為於哪裡?");
			CButtonOne.setText("東京");
			CButtonTwo.setText("山形");
			CButtonThree.setText("神戶");
			CButtonFour.setText("大阪");
	}
	public void FourthQuestion() {
			position = "FourthQuestion";
			TextArea.setText("問題4.\n被稱為“第八藝術”的是?");
			CButtonOne.setText("建築");
			CButtonTwo.setText("電子遊戲");
			CButtonThree.setText("音樂");
			CButtonFour.setText("電影");
	}
	public void GameEnd() {
			ChoicePanel.setVisible(false);
			EndPanel = new JPanel();
			EndPanel.setBackground(Color.BLACK);
			EndPanel.setBounds(300,400,200,100);
			EndButton = new JButton("回到開頭");
			EndButton.setBackground(Color.BLACK);
			EndButton.setForeground(Color.WHITE);
			EndButton.setFont(normalFont);
			EndButton.setFocusPainted(false);
			EndButton.addActionListener(GEHandler);
			EndPanel.add(EndButton);
			con.add(EndPanel);
			TextArea.setText("恭喜你!你完成了所有的問答。\n非常感謝你的遊玩!\n遊戲開發:UShou(宇翔)\n問題和靈感提供:Rushma");
		}
	public class GameEndHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			currect = 0;
			CurrectLabel.setText("答對"+currect+"題");
			TextArea.setVisible(false);
			QuestionPanel.setVisible(false);
			EndPanel.setVisible(false);
			PlayerPanel.setVisible(false);
			TitlePanel.setVisible(true);
			StartPanel.setVisible(true);
		}
	}
	public void RightChoice() {
			currect++;
			CurrectLabel.setText("答對"+currect+"題");
		}
}

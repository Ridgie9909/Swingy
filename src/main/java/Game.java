import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
//  import java.io.*;
// import java.io.FileInputStream;
// import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import project.swingy.view.console;
import project.swingy.writer.*;
import project.swingy.reader.*;





public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4, choice5;
	JTextArea mainTextArea;
	int monsterHP, silverRing;
	static int playerHP;
	String weapon, position;
	public static int level = 7;
	public int var = 0;
	public String weapontype;
	public int wt;
	public int addS;
	public int river;
	public int levelUp = 1;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();


    public static void main(final String[] args) {

      // System.out.println("     North"+ "\n       |" + "\n" + "West  -" + " -   East"+ "\n       |" + "\n" + "     South");
       System.out.println(" __          _                   \n" +
                          "/ _\\_      _(_)_ __   __ _ _   _ \n" +
                          "\\ \\\\ \\ /\\ / / | '_ \\ / _` | | | |\n" +
                          "_\\ \\\\ V  V /| | | | | (_| | |_| |\n" +
                          "\\__/ \\_/\\_/ |_|_| |_|\\__, |\\__, |\n" +
                          "                     |___/ |___/ ");
       try{
			write.create();
			System.out.println("Welcome to Swingy! hope you enjoy your stay.");
			final reader treader = new reader();
			final console con = new console();
			final String var2 = treader.hscanner();

			if (var2.equals("gui")){
				new Game();
				System.out.println("Gui has been selected and please be calm");
			}
			else if (var2.equals("console")){
				/*call console file*/
				System.out.println("Console has been selected and please be wait...");
				con.conreader();
			}
			else{
				System.out.println("Please make sure your input is correct for Ridge's project to run smoothly.");
			}
		}
       finally{

				System.out.println("hello1");
       }

    }
//	public static void main(String[] args) {
//		// new Game();
//
//		Test text = new Test();
//		test1 var =  new test1();
//	}
	
	

	public Game() {


        window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.darkGray);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.darkGray);
		titleNameLabel = new JLabel("Swingy");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.darkGray);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.darkGray);
		startButton.setForeground(Color.darkGray);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.darkGray);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.darkGray);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.darkGray);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.darkGray);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.darkGray);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.darkGray);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.darkGray);
		choice4.setForeground(Color.black);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.darkGray);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
 
		playerSetup();

	}

	public static int levelHp()
	{	
		switch(level){
			case 1:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10;
				System.out.println("You are now level 1 your maximun HP is: " + playerHP);
				break;
			case 2:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10; 
				System.out.println("You are now level 2 your maximun HP is: " + playerHP);
				break;
			case 3:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10; 
				System.out.println("You are now level 3 your maximun HP is: " + playerHP);
				break;
			case 4:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10; 
				System.out.println("You are now level 4 your maximun HP is: " + playerHP);
				break;
			case 5:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10; 
				System.out.println("You are now level 5 your maximun HP is: " + playerHP);
				break;
			case 6:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10; 
				System.out.println("You are now level 6 your maximun HP is: " + playerHP);
				break;
			case 7:
				playerHP = (level * 1000 +(level - 1)^2 * 450) / 10; 
				System.out.println("You are now level 7 your maximun HP is: " + playerHP);
				break;
				default:
				System.out.println("massive ooff");
				
			}
			return playerHP;
		}
		
		/* lucky draw */

//	public int weapontype()
//	{
//		// new Game();
//		Random rand = new Random();
//		wt = rand.nextInt(4);
//		wt += 1;
//		return (wt);
//
//	}
//	 public String weapont()
//	 {
//	 	switch(wt){
//	 		case 1:
//	 			weapontype = "Longsword";
//	 			System.out.println("You are now holding a longsword");
//	 			break;
//	 		case 2:
//	 			weapontype = "Axe";
//	 			System.out.println("You are now holding a Axe");
//	 			break;
//	 		case 3:
//	 			weapontype = "Knife";
//	 			System.out.println("You are now holding a knife");
//	 			break;
//	 		case 4:
//	 			weapontype = "Gun";
//	 			System.out.println("You are now holding a gun");
//	 			break;
//	 		default:
//	 			System.out.println("massive ooff from weapont");
//	 		}
//	 		System.out.println(weapontype);
//	 		return weapontype;
//	 	}
        public int randomnumber()
        {
            final Random rand = new Random();
            int n = rand.nextInt(50);
            n += 1;
            return (n);
        }


	/********************/
	/* Save file stuff */
	/********************/


	// public static String savefile(){
	// 	String filename = "savefile.txt";
	// 	File file = new File("savefile.txt");

	// 	FileInputStream fis = null;
	// 	try{
	// 		fis = new FileInputStream(file);
	// 		System.out.println("What is this data?:"+fis.available());
			
	// 	}
	// 	catch(IOException e){
	// 		System.out.println("You have an error reading your save data\n" + e);

	// 	}
	// 	return filename;
	// }
	

	/********************/
	/*   Player setup	*/
	/********************/

	public void playerSetup()
	{
		playerHP = levelHp();
		monsterHP = 20;
		weapon = weapont();
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		level = 7;
		townGate();
	}


		public String weapont(){

			if (wt == 1){
				weapontype = "Longsword";
				addS = (level * 3 +(level - 1)^2 * 450) / 19;
//				System.out.println("You are now holding a longsword with attack points " + addS+ ".");
			}
			else if(wt == 2){
				weapontype = "Axe";
				addS = (level * 5 +(level - 1)^2 * 450) / 10;
//				System.out.println("You are now holding a axe with attack points " + addS+ ".");
			}
			else if (wt ==  3){
				weapontype = "Knife";
				addS = (level * 2 +(level - 1)^2 * 450) / 11;
//				System.out.println("You are now holding a knife with attack points " + addS+ ".");
			}
			else if (wt == 4){
				weapontype = "Gun";
				addS = (level * 7 +(level - 1)^2 * 450) / 12;
//				System.out.println("You are now holding a gun wit attack points " + addS+ ".");
			}
			else{
				weapontype = "no weapon";
			}
			return weapontype;
		}
    public int levelUP(){
            levelUp = levelUp + 1;
            return levelUp;
    }
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard(){
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive damage)");
		/*******************//********************/
		/*add if for if player has a certain item*/
		/*******************//********************/
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad(){
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	/*currrent working space*/
	public int magicriver(){
		final Random rand = new Random();
		river = rand.nextInt(15);
		river += 1;
		return (river);
	}
	public void north(){
		position = "north";
		mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by " + "insert method here" +")");
		if (playerHP < levelHp()){
			playerHP += magicriver();

		}
		else if (playerHP > levelHp())
			playerHP = playerHP + 1;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go south");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void east(){
		position = "east";
		mainTextArea.setText("You walked into a forest and found a Longsword!\n\n(You obtained a Longsword)");
		weapon = "Longsword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void west(){
		position = "west";
		mainTextArea.setText("You encounter a goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		mainTextArea.setText("Monter HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 3;
		
		if(weapon.equals("Longsword"))
		{
		
			playerDamage = new java.util.Random().nextInt(12) + addS;
			System.out.println("Your total damage is "+playerDamage+ "longsword damage is "+ addS +".");
			
		}
		else if(weapon.equals("Knife"))
		{
			
			playerDamage = new java.util.Random().nextInt(12) + addS; 
			System.out.println("Your total damage is "+playerDamage+ " knife damage is "+ addS +".");
			
			
		}
		else if(weapon.equals("Gun"))
		{
			
			playerDamage = new java.util.Random().nextInt(12) + addS;
			System.out.println("Your total damage is "+playerDamage+ " gun damage is "+ addS +".");
			
		}
		else if(weapon.equals("Axe"))
		{
			
			playerDamage = new java.util.Random().nextInt(12) + addS;
			System.out.println("Your total damage is "+playerDamage+ " axe damage is "+ addS +".");
			
		}
		else
		{
			System.out.println("fudge you dont have a weapon");
		}
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}

	public void monsterAttack(){
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		
		if (playerHP < levelHp())
		{
			playerHP = playerHP - monsterDamage;
		}

		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
		silverRing = 1;
		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}


	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You are dead!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(final ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(final ActionEvent event){
			
			final String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(silverRing==1){
						// levelup()
						ending();
					}
					else{
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": townGate(); break;
				case "c4": west();break;
				}
				break;
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP<1){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;

			case "exit":
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": crossRoad();
				levelUP();
				}
				break;
				
			}
			
			
		}
	}



}

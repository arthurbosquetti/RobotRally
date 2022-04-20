package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import setUp.Game;


public class FirstScreen extends JPanel {
	//Initializing fonts, frame and buttons
	Font title = new Font("SansSerif Bold", Font.PLAIN, 30);
	Font subtitle = new Font("SansSerif", Font.PLAIN, 20);
	JFrame frame = new JFrame("RobotRally Title Screen");
	private JButton easy, mid, hard;
	private JTextField p1name, p2name;
	private static String player1, player2;
	private Game game;
	
	public FirstScreen(Game game) {
		this.game = game;
		
		JLabel name = new JLabel("Robot Rally Game");
		JLabel labelP1 = new JLabel("Name of Player 1:");
	    JLabel labelP2 = new JLabel("Name of Player 2:");
	    JLabel labelDif = new JLabel("Set difficulty and play!");
	    
	    p1name = new JTextField(7);
	    p2name = new JTextField(7);
	    
	    JPanel newPanel = new JPanel(new GridBagLayout());
	    
        //Listener for the buttons
        Clicklistener click = new Clicklistener(game);
        
	    easy = new JButton("Easy");
	    mid = new JButton("Medium");
	    hard = new JButton("Hard");
	   
	    //Setting up the panel
		GridBagConstraints constr = new GridBagConstraints();
		newPanel.setPreferredSize(new Dimension (1000,700));
		newPanel.setBackground(Color.GRAY);
        constr.anchor = GridBagConstraints.WEST;
        constr.insets = new Insets(10, 10, 15, 10);
    
        //Setting all the objects around
        name.setFont(title);
        constr.gridx = 0;
        constr.gridy = 0;     
        newPanel.add(name, constr);

		constr.gridx = 0;
        constr.gridy = 1;     
        newPanel.add(labelP1, constr);
 
        constr.gridx = 1;
        newPanel.add(p1name, constr);
         
        constr.gridx = 0;
        constr.gridy = 2;     
        newPanel.add(labelP2, constr);
 
        constr.gridx = 1;
        newPanel.add(p2name, constr);
         
        labelDif.setFont(subtitle);
        constr.gridx = 0;
        constr.gridy = 6;
        newPanel.add(labelDif, constr);
       
        //Button set up
        constr.gridx = 1;
        constr.anchor = GridBagConstraints.SOUTH;
        constr.gridy = 7;

        easy.addActionListener(click);
        newPanel.add(easy, constr);
        constr.gridy = 8;
        
        mid.addActionListener(click);
        newPanel.add(mid, constr);

        hard.addActionListener(click);
        constr.gridy = 9;
        newPanel.add(hard, constr);
        
        
        //Setting up how the frame looks
        frame.add(newPanel);
		frame.setSize(700, 700);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	

private class Clicklistener implements ActionListener{
		//When user clicks on a button the game starts	
		
	private Game game;
	
	public Clicklistener(Game game) {
		this.game = game;
	}
	
	    public void actionPerformed(ActionEvent e)
	    {
	      player1 = p1name.getText();
	      player2 = p2name.getText();
	      
	      if (e.getSource() == easy)
	      {
	    	game.gameStart("easy", player1, player2);
		  	frame.dispose();
	      }
	      
	      if (e.getSource() == mid)
	      {
	    	game.gameStart("mid", player1, player2);
		  	frame.dispose();
	      }
	      
	      if (e.getSource() == hard)
	      {
	    	 game.gameStart("hard", player1, player2);
			 frame.dispose();
	      }
	    }
	  }
}

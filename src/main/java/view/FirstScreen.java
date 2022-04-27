package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Game;
import io.cucumber.messages.types.Background;


public class FirstScreen extends JPanel {
	//Initializing fonts, frame and buttons
	Font title = new Font("SansSerif Bold", Font.PLAIN, 30);
	Font subtitle = new Font("SansSerif", Font.PLAIN, 20);
	JFrame frame = new JFrame("RobotRally Title Screen");
	private JButton easy, mid, hard;
	private JTextField p1name, p2name;
	private static String player1, player2;
	private JCheckBox AIplayer1, AIplayer2;
	private ImageIcon prettyfaces;
	private Game game;
	
	public FirstScreen(Game game) {
		this.game = game;
		
		JLabel name = new JLabel("Robot Rally Game");
		JLabel labelP1 = new JLabel("Name of Player 1:");
	    JLabel labelP2 = new JLabel("Name of Player 2:");
	    JLabel labelDif = new JLabel("Set difficulty and play!");
	    
	    
	    AIplayer1 = new JCheckBox("is AI?", false);
        AIplayer2 = new JCheckBox("is AI?", false);
	    
	    p1name = new JTextField(7);
	    p2name = new JTextField(7);
	    
	    JPanel newPanel = new JPanel(new GridBagLayout());
	    
        //Listener for the buttons
        Clicklistener click = new Clicklistener();
    	CheckboxListener checkbox = new CheckboxListener();
        
	    easy = new JButton("Easy");
	    mid = new JButton("Medium");
	    hard = new JButton("Hard");
	   
	    //Pretty faces
	    prettyfaces = new ImageIcon("src/main/resources/prettyfaces.JPG");
	    
	    //Setting up the panel
		GridBagConstraints constr = new GridBagConstraints();
		newPanel.setPreferredSize(new Dimension (1000,700));
		newPanel.setBackground(Color.GRAY);
        constr.anchor = GridBagConstraints.WEST;
        constr.insets = new Insets(10, 10, 15, 10);
    
        //Setting all the objects around
        
        constr.gridx = 0;
        constr.gridy = 0;  
        JLabel label = new JLabel();
        label.setIcon(prettyfaces);
        label.setPreferredSize(new Dimension(350, 233));
        newPanel.add(label);
        
        name.setFont(title);
        constr.gridx = 0;
        constr.gridy = 3;     
        newPanel.add(name, constr);

		constr.gridx = 0;
        constr.gridy = 4;     
        newPanel.add(labelP1, constr);
 
        constr.gridx = 1;
        newPanel.add(p1name, constr);
        
        constr.gridx = 2;
        newPanel.add(AIplayer1, constr);
         
        constr.gridx = 0;
        constr.gridy = 6;     
        newPanel.add(labelP2, constr);
 
        constr.gridx = 1;
        newPanel.add(p2name, constr);
        
        constr.gridx = 2;
        newPanel.add(AIplayer2, constr);
         
        labelDif.setFont(subtitle);
        constr.gridx = 0;
        constr.gridy = 8;
        newPanel.add(labelDif, constr);
       
        //Button set up
        constr.gridx = 1;
        constr.anchor = GridBagConstraints.SOUTH;
        constr.gridy = 9;

        easy.addActionListener(click);
        newPanel.add(easy, constr);
        constr.gridy = 10;
        
        mid.addActionListener(click);
        newPanel.add(mid, constr);

        hard.addActionListener(click);
        constr.gridy = 11;
        newPanel.add(hard, constr);
        
	     AIplayer1.addItemListener(checkbox);
	     AIplayer2.addItemListener(checkbox);
        
        //Setting up how the frame looks
        frame.add(newPanel);
		frame.setSize(700, 700);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	

private class Clicklistener implements ActionListener{
	
	    public void actionPerformed(ActionEvent e){
	      
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

private class CheckboxListener implements ItemListener{
	public void itemStateChanged(ItemEvent e){  
		 if(AIplayer1.isSelected()){ 
			 game.setP1AI(true);
		 }
		 else {
			 game.setP1AI(false);
			 }
		 
		 if(AIplayer2.isSelected()){ 
			 game.setP2AI(true);
		}
		 else {
			 game.setP2AI(false);
		 }
				 
			 }
	 
}
}

package view;

import java.awt.*;
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

	class BackgroundPanel extends JPanel
	{
		protected Image bgImage;
		public BackgroundPanel(Image image)
		{
			super(true);
			bgImage = image;
			setOpaque(false);
		}
		public void paint(Graphics g)
		{
			g.drawImage(bgImage, 0 ,0 ,this);
			super.paint(g);
		}
	}

	public FirstScreen(Game game) {
		this.game = game;

		Image img = Toolkit.getDefaultToolkit().getImage("src/main/resources/firstscreenbg.png");
		
		JLabel name = new JLabel("Robot Rally Game");
		JLabel empty = new JLabel(".                                                                                                                                        .");
		JLabel labelP1 = new JLabel("Name of Player 1:");
	    JLabel labelP2 = new JLabel("Name of Player 2:");
	    JLabel labelDif = new JLabel("Set difficulty and play!");
	    JLabel ai = new JLabel("AI");

		labelP1.setForeground(Color.WHITE);
		labelP2.setForeground(Color.WHITE);
		labelDif.setForeground(Color.WHITE);
		ai.setForeground(Color.WHITE);
	    
	    AIplayer1 = new JCheckBox("", false);
        AIplayer2 = new JCheckBox("", false);
	    
	    p1name = new JTextField(7);
	    p2name = new JTextField(7);
	    
	    JPanel newPanel = new BackgroundPanel(img);
		newPanel.setLayout(new GridBagLayout());

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
		newPanel.setPreferredSize(new Dimension (960,540));
		//newPanel.setBackground(Color.GRAY);
        constr.anchor = GridBagConstraints.CENTER;
        constr.insets = new Insets(10, 10, 15, 10);
    
        //Setting all the objects around
        constr.gridy = 3;
        constr.gridx = 3;
        newPanel.add(ai, constr);
        
        constr.weightx = 1.0;
        constr.gridwidth = 1;
        
		constr.gridy = 4;
		constr.gridx = 0;
		newPanel.add(empty, constr);

		constr.gridx = 1;
        newPanel.add(labelP1, constr);
 
        constr.gridx = 2;
        newPanel.add(p1name, constr);
        
        constr.gridx = 3;
        newPanel.add(AIplayer1, constr);
         
        constr.gridx = 1;
        constr.gridy = 6;     
        newPanel.add(labelP2, constr);
 
        constr.gridx = 2;
        newPanel.add(p2name, constr);
        
        constr.gridx = 3;
        newPanel.add(AIplayer2, constr);
         
        labelDif.setFont(subtitle);
        constr.gridx = 1;
        constr.gridy = 8;
		constr.gridwidth = 3;
        newPanel.add(labelDif, constr);
       
        //Button set up
		constr.gridwidth = 1;
        constr.gridx = 2;
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
        frame.add(newPanel, BorderLayout.EAST );
		frame.setSize(960, 540);
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

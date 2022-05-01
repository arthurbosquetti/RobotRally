package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;

public class EndScreen extends JPanel {

	
	public EndScreen(String WinnerName) {
		Image endimg = Toolkit.getDefaultToolkit().getImage("src/main/resources/endscreenbg.png");

		JFrame frame = new JFrame("Game Ended!");
		JButton Okay = new JButton("Okay");
		JLabel text = new JLabel(WinnerName + " has won the game!");
			
		JPanel newPanel = new BackgroundPanel(endimg);
		newPanel.setLayout(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		newPanel.setPreferredSize(new Dimension (450, 350));
		constr.anchor = GridBagConstraints.CENTER;

		Font title = new Font("SansSerif Bold", Font.PLAIN, 30);
		text.setFont(title);
		text.setForeground(Color.WHITE);
		
		constr.gridx = 0;
        constr.gridy = 0;     
        newPanel.add(text, constr);
        
        constr.gridx = 0;
        constr.gridy = 2;     
        newPanel.add(Okay, constr);
        
        frame.add(newPanel);
		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		Okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

	}


}

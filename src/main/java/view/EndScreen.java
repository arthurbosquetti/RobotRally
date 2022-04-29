package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;

public class EndScreen extends JPanel {

	
	public EndScreen(String WinnerName) {
		JFrame frame = new JFrame("Game Ended!");
		JButton Okay = new JButton("Okay");
		JLabel text = new JLabel(WinnerName + " has won the game!");
			
		JPanel newPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		newPanel.setPreferredSize(new Dimension (200, 100));
		
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

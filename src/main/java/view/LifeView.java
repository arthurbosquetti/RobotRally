package view;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LifeView extends JPanel {
	
	private int lives;
	private static int startingLives;
	private LifeIcon[] icons;
	
	public LifeView(int lives, int player) {
		setBackground(Color.DARK_GRAY);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		startingLives = lives;
		this.lives = lives;
		
		JLabel lifeLbl = new JLabel("Lives: ");
		add(lifeLbl);
		lifeLbl.setForeground(Color.WHITE);
		
		icons = new LifeIcon[5];
		
		for (int i = 0; i < lives; i++) {
			icons[i] = new LifeIcon();
			icons[i].setImage("life"+player+".png");
			add(icons[i]);
		}
	}

	
	public void removeLife() {
		Component[] componentList = this.getComponents();
		remove(componentList[componentList.length-1]);
		
		lives--;
	}
	
	
}

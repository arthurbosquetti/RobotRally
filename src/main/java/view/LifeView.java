package view;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LifeView extends JPanel {
	
	private int lives;
	private static int startingLives;
	private LifeIcon[] icons;
	
	public LifeView(int lives, int player) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		startingLives = lives;
		this.lives = lives;
		
		JLabel lifeLbl = new JLabel("Lives: ");
		add(lifeLbl);
		
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

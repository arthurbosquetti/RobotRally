package view;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlagView extends JPanel {
	
	private FlagIcon[] icons;
	
	public FlagView() {
		setBackground(Color.DARK_GRAY);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel flagLbl = new JLabel("Flags collected: ");
		add(flagLbl);
		flagLbl.setForeground(Color.WHITE);
		
		icons = new FlagIcon[2];
	}
	
	public void addFlag(int num) {
		icons[num - 1] =  new FlagIcon();
		icons[num - 1].setFlagNum(num);
		icons[num - 1].setImage("flagIcon"+num+".png");
		add(icons[num - 1]);
	}
	
	
}

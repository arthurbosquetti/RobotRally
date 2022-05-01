package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FlagIcon extends JPanel {
	
	private static final int pixelSize = 30;
	
	private int flagNum;
	
	private BufferedImage flagImg;
	
	public void setFlagNum(int newNum) {
		this.flagNum = newNum;
	}
	
	public void setImage(String img) {
		setBackground(Color.DARK_GRAY);
		try {
			System.out.println("tiles/"+BoardScreen.level+"/"+img);
			flagImg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setMinimumSize(new Dimension(pixelSize, pixelSize));
		setPreferredSize(getMinimumSize());
	}
	
	@Override
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(flagImg, 0, 0, null);
	}
}

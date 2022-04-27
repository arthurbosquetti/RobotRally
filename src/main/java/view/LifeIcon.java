package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LifeIcon extends JPanel {
		
	private static final int pixelSize = 30;
	
	private BufferedImage heartImg;
	
	public void setImage(String img) {
		try {
			System.out.println("tiles/"+BoardScreen.level+"/"+img);
			heartImg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+BoardScreen.level+"/"+img));
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
		g2d.drawImage(heartImg, 0, 0, null);
	}
}

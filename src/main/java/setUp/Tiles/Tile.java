package setUp.Tiles;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import setUp.Robot;;

public abstract class Tile extends JPanel {
	
	private static final String robotLoc = "tiles/robot.png";
	
	private static final long serialVersionUID = -5737440232503577884L;
	public static final int pixelSize = 66;
	private boolean valid;
	private BufferedImage image;
	private Robot robotOn;

	public abstract String tileType();
	public abstract void steppedOn(Robot robot);

	@Override
	public String toString() {
		return " " + this.tileType() + " ";
	}
	
	public Robot robotOn() {
		return robotOn;
	}	
	public void setRobotOn(Robot robot) {
		robotOn = robot;
		System.out.println("works here");
	}
	public void setRobotOff() {
		robotOn = null;
	}
	
	public boolean validTile() {
		return valid;
	}	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
	
	public void setImage(String loc) {
		try {
			this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(loc));
		} catch (IOException e) {
			this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
			System.out.println("oops");
		}
		setMinimumSize(new Dimension(pixelSize, pixelSize));
		setPreferredSize(getMinimumSize());
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
		if (robotOn != null) {
			try {
				BufferedImage robotImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(robotLoc));
				g2d.drawImage(robotImage, 0, 0, null);
				System.out.println("worked");
			} catch (IOException e) {
				System.out.println("oops");
			}
		}
	}
	
}

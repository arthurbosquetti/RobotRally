package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Robot;
import model.tiles.Tile;

public class TileImage extends JPanel {
	
	private Tile tile;
	private BufferedImage image;
	private BufferedImage robotOn;
	
	public TileImage(Tile tile) {
		this.tile = tile;
		
		setImage();
	}
	
	public void setImage() {
        try {
        	image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+BoardScreen.level+"/"+tile.getType()));
        } catch (IOException e) {
        	e.printStackTrace();
        	image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
            System.out.println("oops");
        }
        
        setMinimumSize(new Dimension(BoardScreen.pixelSize, BoardScreen.pixelSize));
		setPreferredSize(getMinimumSize());
	}
	
	public void addRobot(Robot robo) {
		try {	
			robotOn = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+BoardScreen.level+"/"+"robot"+tile.getRobotOn().getNum()+".png"));
		}  catch (IOException e) {
			System.out.println("oops");
		}
		System.out.println("kill me kill me kill me kill me");
		revalidate();
		repaint();
	}
	
	public void removeRobot() {
		robotOn = null;
		revalidate();
		repaint();
	}
	
	@Override
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
		//draw robot on top of tile if there is robot on the board
		if (robotOn != null) {
			System.out.println("this time");
			g2d.drawImage(robotOn, 0, 0, null);
		}
    }
	
}

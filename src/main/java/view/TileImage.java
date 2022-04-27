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
	
	
	@Override
    public void paint(Graphics g) {        
        super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
		//draw robot on top of tile if there is robot on the board
		if (tile.getRobotOn() != null) {
			try {
				BufferedImage robotImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+BoardScreen.level+"/"+"robot"+tile.getRobotOn().getNum()+".png"));
				g2d.drawImage(robotImage, 0, 0, null);
			} catch (IOException e) {
				System.out.println("oops");
			}
		}
        
    }
	
}

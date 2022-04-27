package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Direction;
import model.Robot;
import model.tiles.ConveyorTile;
import model.tiles.Tile;

public class TileImage extends JPanel {
	
	private Tile tile;
	private BufferedImage image;
	
	public TileImage(Tile tile) {
		this.tile = tile;
		
		setImage();
		
	}
	
	public BufferedImage rotateImage(BufferedImage im, Direction dir) {
		int deg = dir.dirToInt();
		final double rads = Math.toRadians(deg);
		final double sin = Math.abs(Math.sin(rads));
		final double cos = Math.abs(Math.cos(rads));
		final int w = (int) Math.floor(im.getWidth() * cos + im.getHeight() * sin);
		final int h = (int) Math.floor(im.getHeight() * cos + im.getWidth() * sin);
		final BufferedImage rotatedImage = new BufferedImage(w, h, im.getType());
		final AffineTransform at = new AffineTransform();
		at.translate(w / 2, h / 2);
		at.rotate(rads,0, 0);
		at.translate(-im.getWidth() / 2, -im.getHeight() / 2);
		final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(im,rotatedImage);
		return rotatedImage;
	}
	
	public void setImage() {
        try {
        	image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+BoardScreen.level+"/"+tile.getType()));
        	if (tile instanceof ConveyorTile) {
        		ConveyorTile s = (ConveyorTile) tile;
        		BufferedImage image2 = rotateImage(image, s.getDir());
        		image = image2;
        	}
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

package model.tiles;


import view.BoardScreen;
import view.TileType;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Game;
import model.Board;
import model.Robot;

public abstract class Tile {	
	private boolean valid;
	private TileType type; 
	private Robot robotOn;


	public abstract String tileType();
	public abstract void steppedOn(Robot robot, Board board, Game game);

	@Override
	public String toString() {
		return " " + this.tileType() + " ";
	}

	public void setRobotOn(Robot robot) {
		robotOn = robot;
	}
	public void setRobotOff() {
		robotOn = null;
	}
	public Robot getRobotOn() {
		return robotOn;
	}
	
	public boolean validTile() {
		return valid;
	}	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}
	
	public void setType(TileType newType) {
		this.type = newType;
	}
	public String getType() {
		return this.type.getPictureFile();
	}
	
	public void draw(Graphics g, BufferedImage image) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image, 0, 0, null);
        //draw robot on top of tile if there is robot on the board
        if (robotOn != null) {
            try {
            	System.out.println("yes!");
                BufferedImage robotImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(BoardScreen.robotLoc));
                g2d.drawImage(robotImage, 0, 0, null);
            } catch (IOException e) {
                System.out.println("oops");
            }
        }
	}
}

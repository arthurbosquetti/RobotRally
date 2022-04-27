package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Board;
import model.Level;
import model.Robot;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BoardScreen extends JPanel {
    private static final long serialVersionUID = -8623078556898821308L;
    public static int size;
    public static int pixelSize;
    public static String level;
    public  static final String robotLoc = "robot.png";
    //TODO: check if making this variable public is a bad idea ;$
    private TileImage[][] tileImages;
    private Board board;

    public BoardScreen(Board board, String newLevel){
    	this.board = board;
        size = board.getBoardSize();
        level = newLevel;
        tileImages = new TileImage[size][size];
        
        setLayout(new GridLayout(size, size));
        
        loadTiles(board);
    }

    public void loadTiles(Board board){
        for (int j = 0; j < size; j++){
            for(int i = 0; i < size; i++){
            	tileImages[j][i] = new TileImage(board.getTile(i, j));
            	add(tileImages[j][i]);
            }
        }
    }
    
    public void removeRobots(Robot robo1, Robot robo2) {
    	tileImages[robo1.getY()][robo1.getX()].removeRobot();
    	tileImages[robo2.getY()][robo2.getX()].removeRobot();
    	
    }
    
    public void addRobots(Robot robo1, Robot robo2) {
    	tileImages[robo1.getY()][robo1.getX()].addRobot(robo1);
    	tileImages[robo2.getY()][robo2.getX()].addRobot(robo2);
    }
    
    public void refreshTiles() {
    	for (TileImage[] imgCol : tileImages) {
    		for (TileImage img : imgCol) {
    			img.repaint();
        	}
    	}
    }
    
    public static void setPixelSize(int newSize) {
    	pixelSize = newSize;
    }
    
    public static void setBoardSize(int newSize) {
    	size = newSize;
    }
}

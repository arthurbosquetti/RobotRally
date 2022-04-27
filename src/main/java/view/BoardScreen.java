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
        
//        setMinimumSize(new Dimension(size*pixelSize, size*pixelSize));
//        setPreferredSize(getMinimumSize());

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

//    @Override
//    public void paint(Graphics g) {
//        super.paintComponent(g);
//        
//        
//    }
    
    public static void setPixelSize(int newSize) {
    	pixelSize = newSize;
    }
    
    public static void setBoardSize(int newSize) {
    	size = newSize;
    }
    
//only one main
//    public static void main(String[] args) {
//        Board board = new Board();
//        Level level = new Level("Easy", board);
//        BoardScreen bs = new BoardScreen(board, 8, "easy");
//        bs.loadTiles(board);
//    }
}

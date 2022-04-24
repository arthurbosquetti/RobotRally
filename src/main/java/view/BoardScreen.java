package view;

import setUp.Board;
import setUp.Level;
import setUp.Robot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BoardScreen extends JPanel {
    private static final long serialVersionUID = -8623078556898821308L;
    private static int size;
    private static final String robotLoc = "robot.png";
    private BufferedImage image;
    private String level;
    private Robot robotOn;

    public BoardScreen(Board board, int size, String level){
        this.size = size;
        this.level = level;
        setLayout(new GridLayout(size, size));

        loadTiles(board);
    }

    public void loadTiles(Board board){
        for (int j = 0; j < size; j++){
            for(int i = 0; i < size; i++){
                if (Objects.equals(board.getTile(i, j).tileType(), "PIT")){
                    setImage("pit.png");
                } else {
                    setImage("empty.png");
                }
            }

        }
    }

    public void setImage(String loc) {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("main/resources/tiles/"+level+"/"+loc));
        } catch (IOException e) {
            this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
            System.out.println("oops");
        }
//        setMinimumSize(new Dimension(pixelSize, pixelSize));
 //       setPreferredSize(getMinimumSize());
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image, 0, 0, null);
        //draw robot on top of tile if there is robot on the board
        if (robotOn != null) {
            try {
                BufferedImage robotImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(robotLoc));
                g2d.drawImage(robotImage, 0, 0, null);
            } catch (IOException e) {
                System.out.println("oops");
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        Level level = new Level("Easy", board);
        BoardScreen bs = new BoardScreen(board, 8, "easy");
        bs.loadTiles(board);
    }
}

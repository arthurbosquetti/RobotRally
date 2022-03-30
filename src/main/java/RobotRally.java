import setUp.Board;
import setUp.Tiles.Tile;
import setUp.Tiles.TallObstacle;
import setUp.Robot;

public class RobotRally {
	
	public static void main(String[] args) {
		
		//Board & Robot for testing
		Board board = new Board();
		board.setTile(2, 2, new TallObstacle());
		
	
		Robot robo = new Robot("dev");
		robo.setX(2);
		robo.setY(3);
		
		//able to print a board with a robot
		//board.printBoard();
		
		//printing board with robot on it
		board.printBoard(robo);
		
		//make move function working
		board.makeMove(robo, true, 1);
		
		
	}
	
}

package setUp.Tiles;

import setUp.Board;
import setUp.Game;
import setUp.Robot;

public class TeleportTile extends Tile {
	
	public TeleportTile() {
		this.setValid(true);
	}
	
    @Override
    public String tileType() {
        return " |0|";
    }
    
    public int[] findOtherTeleportTile(Robot robot, Board board) {
    	int[] otherTile = new int[2];
    	int x = robot.getX(); int y = robot.getY();
    	int [][] tiles = board.searchBoard(this);
    	if (tiles[0][0] == y && tiles[0][1] == x) { 
    		otherTile[0] = tiles[1][0];
    		otherTile[1] = tiles[1][1];
    	}
    	else {
    		otherTile[0] = tiles[0][0];
    		otherTile[1] = tiles[0][1];
    	}
    	return otherTile;
    }
    
    @Override
	public void steppedOn(Robot robot, Board board, Game game) {
	  int[] otherTile = findOtherTeleportTile(robot, board);
	  robot.setX(otherTile[1]);
	  robot.setY(otherTile[0]);
	}
}

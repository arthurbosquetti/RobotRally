package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class TeleportTile extends Tile { //always teleports you to middle of board
	
	public TeleportTile() {
		this.setValid(true);
		this.setType(TileType.PORTAL);
	}
	
    @Override
    public String tileType() {
        return " |0|";
    }
    
    public int[] findOtherTeleportTile(Robot robot, Board board) {
    	int[] otherTile = new int[2];
    	int x = robot.getX(); int y = robot.getY();
    	int [][] tiles = board.searchBoard();
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
    	
      int[] other = findOtherTeleportTile(robot, board);
  	  robot.setX(other[1]);
  	  robot.setY(other[0]);

	}
}

package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.TileType;

public class TeleportTile extends Tile {
	
	//TODO: change this to real type/add teleport type
	public TeleportTile() {
		this.setValid(true);
		this.setType(TileType.PIT);
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

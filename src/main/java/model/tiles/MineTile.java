package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
import view.BoardScreen;
import view.TileType;

public class MineTile extends Tile{ // now used as kamikaze tile!!!!

	public MineTile() {
		this.setValid(true);
		this.setType(TileType.MINE);
	}
	
    @Override
    public String tileType() {
        return " |m|";
    }
    
    @Override
	public void steppedOn(Robot robot, Board board, Game game) {
    	int[] otherPlayer = game.findOtherPlayer(robot);
    	int otherX = otherPlayer[0];
    	int otherY = otherPlayer[1];
    	
    	int Y = robot.getY(); int X = robot.getX();
    	
    	robot.hurt(1);
    	if (Math.abs(X-otherX) <= 1 && Math.abs(Y-otherY) <= 1) {
    		game.hurtOtherPlayer(robot);
    	}   	
	}
}

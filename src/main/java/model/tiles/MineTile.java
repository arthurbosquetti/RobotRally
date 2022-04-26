package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;
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
    	int otherC = game.findOtherPlayer(robot)[0];
    	int otherR = game.findOtherPlayer(robot)[1];
    	int rc = board.getBoardSize();
    	
    	robot.hurt(1);
    	int R = robot.getY(); int C = robot.getX();
    	
    	if (R > 0 && R < rc-1 && C > 0 && C < rc-1) {
    		for (int i=R-1; i<R+2; i++) {
        		for (int j=C-1; j<C+2; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R == 0 &&  C > 0 && C < rc-1) {
    		for (int i=R; i<R+2; i++) {
        		for (int j=C-1; j<C+2; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R == rc-1 &&  C > 0 && C < rc-1) {
    		for (int i=R-1; i<R+1; i++) {
        		for (int j=C-1; j<C+2; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R > 0 && R < rc-1 &&  C == 0) {
    		for (int i=R-1; i<R+2; i++) {
        		for (int j=C; j<C+2; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R > 0 && R < rc-1 &&  C == rc-1) {
    		for (int i=R-1; i<R+2; i++) {
        		for (int j=C-1; j<C+1; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R == 0 && C == 0) {
    		for (int i=R; i<R+2; i++) {
        		for (int j=C; j<C+2; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R == rc-1 && C == 0) {
    		for (int i=R-1; i<R+1; i++) {
        		for (int j=C; j<C+2; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R == 0 && C == rc-1) {
    		for (int i=R; i<R+2; i++) {
        		for (int j=C-1; j<C+1; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}
    	
    	else if (R == rc-1 && C == rc-1) {
    		for (int i=R-1; i<R+1; i++) {
        		for (int j=C-1; j<C+1; j++) {
        			if (otherR == i && otherC == j) {
        				game.hurtOtherPlayer(robot);
        			}
        		}
        	}
    	}    	
	}
}

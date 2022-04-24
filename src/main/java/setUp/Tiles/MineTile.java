package setUp.Tiles;

import setUp.Board;
import setUp.Robot;
import setUp.Game;

public class MineTile extends Tile{ // now used as kamikaze tile!!!!

	public MineTile() {
		this.setValid(true);
	}
	
    @Override
    public String tileType() {
        return " |m|";
    }
    
    @Override
	public void steppedOn(Robot robot, Board board, Game game) {
    	robot.hurt(1);
		game.hurtOtherPlayer(robot);
	}
}

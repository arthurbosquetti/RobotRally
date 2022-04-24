package setUp.Tiles;

import setUp.Board;
import setUp.Robot;

public class MineTile extends Tile{

	public MineTile() {
		this.setValid(true);
	}
	
    @Override
    public String tileType() {
        return " |m|";
    }
    
    @Override
	public void steppedOn(Robot robot, Board board) {
		// TODO Auto-generated method stub
		// for the 3x3 area do hurt
    	int x = robot.getX();
    	int y = robot.getY();
    	
    	int rc = board.getBoardSize();
    	//int coords[][] = board.whereAreThey(robot, robot);
    	
    	//  inside case
    	if (x > 0 && x < rc && y > 0 && y < rc) {
    		for (int i = x-1; i <= x+1; i++) {
    			for (int j = y-1; j <= y+1; j++) {
    				//tile(i,j).robotOn.hurt(1);
    			}
    		}
    	}
    	//
    	
		
	}
}

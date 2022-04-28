package model;

import model.tiles.GlueTile;
import model.tiles.MineTile;
import model.tiles.PitTile;
import model.tiles.TeleportTile;

public class MovingCard {
	private int moved_forward;
	
	public void detMove(String action, Robot robot, Board board) {
		if (action.equals("F1")) {
			board.makeMove(robot, true, 1, false);
			this.moved_forward = 1;
		}
		else if (action.equals("F2")) {
			
			// make sure it stops when it hits an obstacle
			board.makeMove(robot, true, 1, false);
			if (robot.getTile() instanceof MineTile || robot.getTile() instanceof GlueTile || robot.getTile() instanceof PitTile || robot.getTile() instanceof TeleportTile) {
				this.moved_forward = 1;
			}
			else {
				board.makeMove(robot, true, 1, false);
				this.moved_forward = 2;
			}
		}

		else if (action.equals("F3")) {
			
			// make sure it stops when it hits an obstacle		
			board.makeMove(robot, true, 1, false);
			if (robot.getTile() instanceof MineTile || robot.getTile() instanceof GlueTile || robot.getTile() instanceof PitTile || robot.getTile() instanceof TeleportTile) {
				this.moved_forward = 1;
			}
			else {
				board.makeMove(robot, true, 1, false);
				if (robot.getTile() instanceof MineTile || robot.getTile() instanceof GlueTile || robot.getTile() instanceof PitTile || robot.getTile() instanceof TeleportTile) {
					this.moved_forward = 2;
				}
				else {
					board.makeMove(robot, true, 1, false);
					this.moved_forward = 3;
				}
			}
		}
		
		
		else if (action.equals("B"))	{
			board.makeMove(robot, false, 1, false);
			this.moved_forward = -1;
		}
		else if (action.equals("J")) {
			board.makeMove(robot, true, 2, true);
			this.moved_forward = 2;
		}
		else if (action.equals("NO")) {
			board.makeMove(robot, true, 0, false);
			this.moved_forward = 0;
		}

	}

	public int get_MovedForward() {
		return this.moved_forward;
	}
}

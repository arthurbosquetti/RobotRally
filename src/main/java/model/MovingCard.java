package model;

import model.tiles.GlueTile;
import model.tiles.MineTile;
import model.tiles.PitTile;
import model.tiles.TeleportTile;

public class MovingCard {
	private int moved_forward;
	
	public void detMove(String action, Robot robot, Movement mov) {
		if (action.equals("F1")) {
			mov.makeMove(robot, true, 1, false);
			this.moved_forward = 1;
		}
		else if (action.equals("F2")) {
			
			// make sure it stops when it hits an obstacle
			mov.makeMove(robot, true, 1, false);
			if (robot.getTile() instanceof MineTile || robot.getTile() instanceof GlueTile || robot.getTile() instanceof PitTile || robot.getTile() instanceof TeleportTile) {
				this.moved_forward = 1;
			}
			else {
				mov.makeMove(robot, true, 1, false);
				this.moved_forward = 2;
			}
		}

		else if (action.equals("F3")) {
			
			// make sure it stops when it hits an obstacle		
			mov.makeMove(robot, true, 1, false);
			if (robot.getTile() instanceof MineTile || robot.getTile() instanceof GlueTile || robot.getTile() instanceof PitTile || robot.getTile() instanceof TeleportTile) {
				this.moved_forward = 1;
			}
			else {
				mov.makeMove(robot, true, 1, false);
				if (robot.getTile() instanceof MineTile || robot.getTile() instanceof GlueTile || robot.getTile() instanceof PitTile || robot.getTile() instanceof TeleportTile) {
					this.moved_forward = 2;
				}
				else {
					mov.makeMove(robot, true, 1, false);
					this.moved_forward = 3;
				}
			}
		}
		
		
		else if (action.equals("B"))	{
			mov.makeMove(robot, false, 1, false);
			this.moved_forward = -1;
		}
		else if (action.equals("J")) {
			mov.makeMove(robot, true, 2, true);
			this.moved_forward = 2;
		}

	}

	public int get_MovedForward() {
		return this.moved_forward;
	}
}

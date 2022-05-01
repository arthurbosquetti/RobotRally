package model;

public class Movement {

	private Board board;
	//private Movement mov= new Movement(this);
	

	public Movement(Board newBoard) {
		this.board = newBoard;
	}

	public boolean checkMove(int[] point) {
		int x = point[0];
		int y = point[1];
		if (x < 0 || x >= board.getBoardSize() || y < 0 || y >= board.getBoardSize()) {
//			System.out.println("Error: move out of board");
			return false;
		} else if (board.getTile(x, y).validTile()) {
			return true;
		} else
//			System.out.println("move failed, obstacle in the way");
			return false;
	}

	public int[] getNewPoint(Direction dir, int x, int y, boolean forward, int step) {
		switch (dir.getDirection()) {
			case "north":
				return (forward)? new int[]{x, y - step} : new int[]{x, y + step};
			case "east":
				return (forward)? new int[]{x + step, y} : new int[]{x - step, y};

			case "south":
				return (forward)? new int[]{x, y + step} : new int[]{x, y - step};

			case "west":
				return (forward)? new int[]{x - step, y} : new int[]{x + step, y};

			default:
				System.out.println("Error in getNewPoint, direction not found");
				return new int[]{x, y};
		}
	}
	
	// Method for robot to be moved on the board
		public boolean makeMove(Robot robot, boolean forward, int steps, boolean jump) {
			// Gets the next point based on move
			int xO=robot.getX();
			int yO=robot.getY();
			int[] newPoint = this.getNewPoint(robot.getDir(), robot.getX(), robot.getY(), forward, steps);
			
			// Doesn't let robot jump if there is a tall obstacle in front
			if (jump) {
				int [] midPoint = this.getNewPoint(robot.getDir(), robot.getX(), robot.getY(), true, 1);
				if (!(this.checkMove(midPoint))) {
					return false;
				}
			}
			// Checks move for validity: runs code to move robot
			if (this.checkMove(newPoint)) {
				if (board.getTile(newPoint[0], newPoint[1]).getRobotOn()!=null) {
					return false;
				}
				// Remove robot from previous tile
				board.getBoardLayout()[robot.getY()][robot.getX()].setRobotOff();
				// Move robot to new tile
				robot.nextTile(board.getTile(newPoint[0], newPoint[1]));
				robot.setX(newPoint[0]);
				robot.setY(newPoint[1]);
				robot.move();
				try {
					updateRobotPos(robot);
				} catch (Exception e) { // Exceptions
					System.out.println("The robot is "+robot.getName());
					System.out.println("Robot starts at ("+xO+","+yO+")");
					System.out.println("newPoint[][]= {"+newPoint[0]+","+newPoint[1]+"}");
					System.out.println("Next tile is "+board.getTile(newPoint[0], newPoint[1]).getType());
					System.out.println("Robot is at ("+robot.getX()+","+robot.getX()+")");
					
					e.printStackTrace();
				}
				return true;
			}
			// Code for when robot can't move forward
			return false;
		}
		
		// Sets the robot on new tile, used in makeMove
		public void updateRobotPos(Robot robot) throws Exception {
			board.getBoardLayout()[robot.getY()][robot.getX()].setRobotOn(robot);
		}
}

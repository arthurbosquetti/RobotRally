//package setUp;
//
//public class MovingCard {
//	private int steps;
//	private int moved_forward;
//
//	public void detMove(String action, Robot robot, Board board) {
//		if (action.equals("F1")) {
//			board.makeMove(robot, true, 1, false);
//			this.moved_forward = 1;
//		}
//		else if (action.equals("F2")) {
//			board.makeMove(robot, true, 1, false);
//			board.makeMove(robot, true, 1, false);
//			this.moved_forward = 2;
//		}
//		else if (action.equals("F3")) {
//			board.makeMove(robot, true, 1, false);
//			board.makeMove(robot, true, 1, false);
//			board.makeMove(robot, true, 1, false);
//			this.moved_forward = 3;
//		}
//		else if (action.equals("B"))	{
//			board.makeMove(robot, false, 1, false);
//			this.moved_forward = -1;
//		}
//		else if (action.equals("J")) {
//			board.makeMove(robot, true, 2, true);
//		}
//
//	}
//
//	public int get_MovedForward() {
//		return this.moved_forward;
//	}
//}

package model.tiles;

import controller.Game;
import model.Board;
import model.Robot;

public interface InteractsWithTile extends RobotSetOnOff {
    void steppedOn(Robot robot, Board board, Game game);
}

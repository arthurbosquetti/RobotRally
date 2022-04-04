package setUp.Tiles;

import setUp.Robot;

public class TallObstacle extends Tile {

//    public TallObstacle() {
//        super(TileType.TALL, false);
//    }

    @Override
    public String tileType() {
        return " T ";
    }

    @Override
    public void steppedOn(Robot robot) {
        robot.hurt(1);
    }
}

package setUp.Tiles;

import setUp.Robot;

public class EmptyTile extends Tile{
    @Override
    public String tileType() {
        return " _ ";
    }

    @Override
    public void steppedOn(Robot robot) {}
}

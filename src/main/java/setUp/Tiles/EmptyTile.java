package setUp.Tiles;

import setUp.Robot;

public class EmptyTile extends Tile{
    @Override
    public String tileType() {
        return "E";
    }

    @Override
    public void steppedOn(Robot robot) {}
}

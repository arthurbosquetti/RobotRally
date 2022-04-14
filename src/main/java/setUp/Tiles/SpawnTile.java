package setUp.Tiles;

import setUp.Robot;

public class SpawnTile extends Tile {
    private int spawnNum;
    public SpawnTile() {
        this.setValid(true);
    }
    public SpawnTile(int spawnNum) {
        this.spawnNum = spawnNum;
    }

    @Override
    public String tileType() {
        return " |" + spawnNum+"|";
    }

    @Override
    public void steppedOn(Robot robot) {
    }
}

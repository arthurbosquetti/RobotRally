package setUp.Tiles;

public class TileFactory {
    public static Tile getTile(String tile) {
        if (tile.equalsIgnoreCase("FLAG1")) {
            return new FlagTile(1);
        } else if (tile.equalsIgnoreCase("FLAG2")) {
            return new FlagTile(2);
        } else if (tile.equalsIgnoreCase("PIT")) {
            return new PitObstacle();
        } else if (tile.equalsIgnoreCase("TALL")) {
            return new TallObstacle();
        } else if (tile.equalsIgnoreCase("EMPTY")) {
            return new EmptyTile();
        }
        return null;
    }
}

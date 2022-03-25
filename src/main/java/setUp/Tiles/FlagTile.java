package setUp.Tiles;

import setUp.Player;

public class FlagTile extends Tile {

    public FlagTile() {
        super(TileType.FLAG);
    }
    
    public void hit(Player player) {
    	player.setLives(player.getLives() + 1);
    }


}

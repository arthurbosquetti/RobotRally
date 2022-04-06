package setUp.Tiles;

import setUp.Robot;

public class EmptyTile extends Tile{
	
	public EmptyTile() {
		this.setValid(true);
	}
	
    @Override
    public String tileType() {
        return " |_|";
    }

    @Override
    public void steppedOn(Robot robot) {}
}

package setUp.Tiles;

import setUp.Robot;

public class MineTile extends Tile{

	public MineTile() {
		this.setValid(true);
	}
	
    @Override
    public String tileType() {
        return " |M|";
    }

    @Override
    public void steppedOn(Robot robot) {
    	//TODO
    }
}

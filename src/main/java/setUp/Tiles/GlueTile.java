package setUp.Tiles;

import setUp.Robot;

public class GlueTile extends Tile {

	public GlueTile() {
		this.setValid(true);
		this.setImage("tiles/acid.png");
	}
	
    @Override
    public String tileType() {
        return " |G|";
    }

    @Override
    public void steppedOn(Robot robot) {
    	//TODO: this
    }


}

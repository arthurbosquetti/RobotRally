package setUp.Tiles;

import setUp.Robot;

public class GlueTile extends Tile {

	public GlueTile() {
		this.setValid(true);
		this.setImage("acid.png");
	}
	
    @Override
    public String tileType() {
        return " |G|";
    }

    @Override
    public void steppedOn(Robot robot) {
    	robot.setGlue(false); // then canMove is true, but might be too confusing
    }


}

package setUp.Tiles;

public enum TileType {
	
	OPEN_FLOOR("tiles/floor.png"),
	PIT("tiles/pit.png"),
	ACID("tiles/acid.png"),
	FLAG("tiles/flag.png"),
	RADIATION("tiles/radiation.png");

	
	private String pictureFile;
	
	private TileType(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}
}

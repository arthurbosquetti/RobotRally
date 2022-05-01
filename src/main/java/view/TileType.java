package view;

public enum TileType {
	
	EMPTY("empty.png"),
    FLAG1("flag1.png"),
    FLAG2("flag2.png"),
    CONVEYOR("conveyor.png"),
    GLUE("glue.png"),
    MINE("mine.png"),
    PIT("pit.png"),
    PORTAL("portal.png"),
    SPAWN1("spawn1.png"),
    SPAWN2("spawn2.png"),
    TALL("tall.png");

    private String pictureFile;

    TileType(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getPictureFile() {
        return pictureFile;
    }
}

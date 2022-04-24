package view;

public enum EasyTiles {

    EMPTY("main/resources/tiles/easy/empty.png"),
    FLAG1("main/resources/tiles/easy/flag1.png"),
    FLAG2("main/resources/tiles/easy/flag2.png"),
    CONVEYOR("main/resources/tiles/easy/conveyor.png"),
    GLUE("main/resources/tiles/easy/glue.png"),
    MINE("main/resources/tiles/easy/mine.png"),
    PIT("main/resources/tiles/easy/pit.png"),
    PORTAL("main/resources/tiles/easy/portal.png"),
    SPAWN1("main/resources/tiles/easy/spawn1.png"),
    SPAWN2("main/resources/tiles/easy/spawn2.png"),
    TALL("main/resources/tiles/easy/tall.png");

    private String pictureFile;

    private EasyTiles(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getPictureFile() {
        return pictureFile;
    }
}

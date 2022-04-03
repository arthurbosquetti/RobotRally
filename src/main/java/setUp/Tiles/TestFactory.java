package setUp.Tiles;

import java.util.Random;

public class TestFactory {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int randInt = r.nextInt(3);
            switch (randInt) {
                case 0:
                    Tile flag = TileFactory.getTile("FLAG");
                    System.out.println(flag);
                    break;
                case 1:
                    Tile pit = TileFactory.getTile("PIT");
                    System.out.println(pit);
                    break;
                case 2:
                    Tile tall = TileFactory.getTile("TALL");
                    System.out.println(tall);
                    break;
                default:
                    System.out.println("Outta bounds");
            }
        }
    }
}

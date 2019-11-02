package co.aplicared.jvm.juego.arbúcies.graphics;

public class Sprite {
    public static Sprite grassSprite = new Sprite(16, 0, 0, SpriteSheet.terrain);
    public static Sprite voidSprite = new Sprite(16, 0x3b9eb5);

    public static Sprite player0Sprite = new Sprite(16, 1, 0, SpriteSheet.terrain);
    public static Sprite player1Sprite = new Sprite(16, 2, 0, SpriteSheet.terrain);
    public static Sprite player2Sprite = new Sprite(16, 3, 0, SpriteSheet.terrain);
    public static Sprite player3Sprite = new Sprite(16, 4, 0, SpriteSheet.terrain);

    public int size, xCoord, yCoord;
    public SpriteSheet sheet;
    public int[] pixels;

    public Sprite(int size, int xCoord, int yCoord, SpriteSheet sheet) {
        this.size = size;
        pixels = new int[size * size];
        this.xCoord = xCoord * size;
        this.yCoord = yCoord * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int colour) {
        this.size = size;
        pixels = new int[size * size];
        setColour(colour);
    }

    private void setColour(int colour) {
        for (int i = 0; i < size * size; i++) {
            pixels[i] = colour;
        }
    }

    private void load() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                pixels[x + y * size] = sheet.pixels[(x + xCoord) + (y + yCoord) * sheet.size];
            }
        }
    }
}

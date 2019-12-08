package co.aplicared.jvm.juego.arbúcies.graphics;

public class Sprite {

    /**
     * Tile Sprites
     */

    public static Sprite grassSprite = new Sprite(16, 0, 0, SpriteSheet.terrain);
    public static Sprite voidSprite = new Sprite(16, 0x3b9eb5);

    /**
     * Player 1 Sprites
     */
    // Back
    public static Sprite player0Bck0 = new Sprite(32, 0, 0, SpriteSheet.player);
    public static Sprite player0Bck1 = new Sprite(32, 0, 1, SpriteSheet.player);

    // Right
    public static Sprite player0Rght0 = new Sprite(32, 1, 0, SpriteSheet.player);
    public static Sprite player0Rght1 = new Sprite(32, 1, 1, SpriteSheet.player);

    // Front
    public static Sprite player0Frnt0 = new Sprite(32, 2, 0, SpriteSheet.player);
    public static Sprite player0Frnt1 = new Sprite(32, 2, 1, SpriteSheet.player);

    // Left
    public static Sprite player0Left0 = new Sprite(32, 3, 0, SpriteSheet.player);
    public static Sprite player0Left1 = new Sprite(32, 3, 1, SpriteSheet.player);

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

package co.aplicared.jvm.juego.arbúcies.util;

public enum Colours {
    WHITE(0xFFFFFF, 0xFFFFFFFF),
    BLACK(0x000000, 0xFF000000),
    TRANSPARENT(0xef00ff, 0xFFef00ff),
    TEX_LIGHT_GRASS(0xFF0000, 0xffff0000),
    TEX_DARK_GRASS(0xFFFF00, 0xffffff00),
    TEX_LIGHT_INFERNO(0x7F0000, 0xFF7f0000),
    TEX_DARK_INFERNO(0x7F7f00, 0xFF7f7f00),
    TEX_STONE(0xC70000, 0xFFc70000),
    TEX_DIRT(0xC7c700, 0xFFc7c700);

    private final int rgb;
    private final int rgba;

    Colours(int RGB, int RGBA) {
        rgb = RGB;
        rgba = RGBA;
    }

    public int RGB() {
        return rgb;
    }

    public int RGBA() {
        return rgba;
    }
}

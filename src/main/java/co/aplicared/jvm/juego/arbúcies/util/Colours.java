package co.aplicared.jvm.juego.arbúcies.util;

public enum Colours {
    WHITE(0xFFFFFF, 0xFFFFFFFF),
    BLACK(0x000000, 0xFF000000),
    TRANSPARENT(0xFF00FF, 0xFFFF00FF);

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

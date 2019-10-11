package co.aplicared.jvm.juego.arbúcies.graphics;

public class Screen {
    public int[] pixels;
    private int _width, _height;

    public Screen(int width, int height) {
        this._width = width;
        this._height = height;

        pixels = new int[_width * _height];
    }

    public void render() {
        for (int y = 0; y < _height; y++) {
            for (int x = 0; x < _width; x++) {
                pixels[x + y * _width] = 0xff00ff;
            }
        }
    }
}

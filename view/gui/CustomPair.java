package view.gui;

public class CustomPair {

    public int X;
    public int Y;

    public CustomPair(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String toString() {
        return (X + ", " + Y);
    }
}

package view.gui;

public class Custom_Pair {

    public int X;
    public int Y;

    public Custom_Pair(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int get_X() {
        return X;
    }

    public int get_Y() {
        return Y;
    }

    public String toString() {
        return (X + ", " + Y);
    }
}

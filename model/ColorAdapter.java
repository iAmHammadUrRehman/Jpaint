package model;

import java.awt.*;

public class ColorAdapter {

    Color color;
    ShapeColor colorEnum;

    public ColorAdapter(Color color, ShapeColor colorEnum) {
        this.color = color;
        this.colorEnum = colorEnum;
    }


    public String toString() {
        return colorEnum.toString();
    }

    public Color getColor() {
        return color;
    }
}

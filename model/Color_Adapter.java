package model;

import java.awt.*;

public class Color_Adapter {

    Color color;
    Shape_Color color_Enum;

    public Color_Adapter(Color color, Shape_Color color_Enum) {
        this.color = color;
        this.color_Enum = color_Enum;
    }


    public String toString() {
        return color_Enum.toString();
    }

    public Color get_Color() {
        return color;
    }
}

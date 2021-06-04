package model;

public class Shape_Configuration {
    public Color_Adapter primary_Color;
    public Color_Adapter secondary_Color;
    public Shape_Type shape_Type;
    public Shape_Shading_Type shading_Type;

    public Shape_Configuration(Color_Adapter primary_Color, Color_Adapter secondary_Color,
                               Shape_Type shape_Type, Shape_Shading_Type shading_Type) {

        this.primary_Color = primary_Color;
        this.secondary_Color = secondary_Color;
        this.shape_Type = shape_Type;
        this.shading_Type = shading_Type;
    }

}

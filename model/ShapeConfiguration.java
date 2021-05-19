package model;

public class ShapeConfiguration {
    public ColorAdapter primaryColor;
    public ColorAdapter secondaryColor;
    public ShapeType shapeType;
    public ShapeShadingType shadingType;

    public ShapeConfiguration(ColorAdapter primaryColor, ColorAdapter secondaryColor,
                              ShapeType shapeType, ShapeShadingType shadingType) {

        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
    }

}

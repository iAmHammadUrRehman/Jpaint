package model.shapeManipulation;

import java.awt.*;

public class Rectangle_Strategy implements I_Shape_Drawer {

    @Override
    public void draw(Create_Shape shape, Graphics2D graphics2d) {

        switch (shape.shading_Type) {

            case OUTLINE:
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillRect(shape.X, shape.Y, shape.width, shape.height);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondary_Color);
                graphics2d.drawRect(shape.X, shape.Y, shape.width, shape.height);
                break;

            case FILLED_IN:
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillRect(shape.X, shape.Y, shape.width, shape.height);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primary_Color);
                graphics2d.drawRect(shape.X, shape.Y, shape.width, shape.height);
                break;

            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillRect(shape.X, shape.Y, shape.width, shape.height);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondary_Color);
                graphics2d.drawRect(shape.X, shape.Y, shape.width, shape.height);
                break;

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

package model.shapeManipulation;

import java.awt.*;

public class Circle_Strategy implements I_Shape_Drawer {

    @Override
    public void draw(Create_Shape shape, Graphics2D graphics2d) {

        switch (shape.shading_Type) {
            case OUTLINE:
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillOval(shape.X, shape.Y, shape.width, shape.width);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondary_Color);
                graphics2d.drawOval(shape.X, shape.Y, shape.width, shape.width);
                break;

            case FILLED_IN:
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillOval(shape.X, shape.Y, shape.width, shape.width);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primary_Color);
                graphics2d.drawOval(shape.X, shape.Y, shape.width, shape.width);
                break;

            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillOval(shape.X, shape.Y, shape.width, shape.width);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondary_Color);
                graphics2d.drawOval(shape.X, shape.Y, shape.width, shape.width);
                break;

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}



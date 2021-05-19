package model.shapeManipulation;

import java.awt.*;

public class CircleStrategy implements IShapeDrawer {

    @Override
    public void draw(CreateShape shape, Graphics2D graphics2d) {

        switch (shape.shadingType) {
            case OUTLINE:
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillOval(shape.X, shape.Y, shape.width, shape.width);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondaryColor);
                graphics2d.drawOval(shape.X, shape.Y, shape.width, shape.width);
                break;

            case FILLED_IN:
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillOval(shape.X, shape.Y, shape.width, shape.width);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primaryColor);
                graphics2d.drawOval(shape.X, shape.Y, shape.width, shape.width);
                break;

            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillOval(shape.X, shape.Y, shape.width, shape.width);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondaryColor);
                graphics2d.drawOval(shape.X, shape.Y, shape.width, shape.width);
                break;

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}



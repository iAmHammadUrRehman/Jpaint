package model.shapeManipulation;

import java.awt.*;

public class RectangleStrategy implements IShapeDrawer {

    @Override
    public void draw(CreateShape shape, Graphics2D graphics2d) {

        switch (shape.shadingType) {

            case OUTLINE:
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillRect(shape.X, shape.Y, shape.width, shape.height);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondaryColor);
                graphics2d.drawRect(shape.X, shape.Y, shape.width, shape.height);
                break;

            case FILLED_IN:
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillRect(shape.X, shape.Y, shape.width, shape.height);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primaryColor);
                graphics2d.drawRect(shape.X, shape.Y, shape.width, shape.height);
                break;

            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillRect(shape.X, shape.Y, shape.width, shape.height);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondaryColor);
                graphics2d.drawRect(shape.X, shape.Y, shape.width, shape.height);
                break;

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

package model.shapeManipulation;

import java.awt.*;

public class TriangleStrategy implements IShapeDrawer {

    @Override
    public void draw(CreateShape shape, Graphics2D graphics2d) {

        int[] xCoords = new int[3];
        xCoords[0] = shape.startingPair.X;
        xCoords[1] = shape.startingPair.X;
        xCoords[2] = shape.endingPair.X;

        int[] yCoords = new int[3];
        yCoords[0] = shape.startingPair.Y;
        yCoords[1] = shape.endingPair.Y;
        yCoords[2] = shape.endingPair.Y;


        switch (shape.shadingType) {

            case OUTLINE:
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillPolygon(xCoords, yCoords, 3);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primaryColor);
                graphics2d.drawPolygon(xCoords, yCoords, 3);
                break;

            case FILLED_IN:
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillPolygon(xCoords, yCoords, 3);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillPolygon(xCoords, yCoords, 3);
                break;

            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.primaryColor);
                graphics2d.fillPolygon(xCoords, yCoords, 3);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondaryColor);
                graphics2d.drawPolygon(xCoords, yCoords, 3);
                break;

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}



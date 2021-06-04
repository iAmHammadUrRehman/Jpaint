package model.shapeManipulation;

import java.awt.*;

public class Triangle_Strategy implements I_Shape_Drawer {

    @Override
    public void draw(Create_Shape shape, Graphics2D graphics2d) {

        int[] x_Co_ords = new int[3];
        x_Co_ords[0] = shape.starting_Pair.X;
        x_Co_ords[1] = shape.starting_Pair.X;
        x_Co_ords[2] = shape.ending_Pair.X;

        int[] y_Co_ords = new int[3];
        y_Co_ords[0] = shape.starting_Pair.Y;
        y_Co_ords[1] = shape.ending_Pair.Y;
        y_Co_ords[2] = shape.ending_Pair.Y;


        switch (shape.shading_Type) {

            case OUTLINE:
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillPolygon(x_Co_ords, y_Co_ords, 3);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primary_Color);
                graphics2d.drawPolygon(x_Co_ords, y_Co_ords, 3);
                break;

            case FILLED_IN:
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillPolygon(x_Co_ords, y_Co_ords, 3);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillPolygon(x_Co_ords, y_Co_ords, 3);
                break;

            case OUTLINE_AND_FILLED_IN:
                graphics2d.setColor(shape.primary_Color);
                graphics2d.fillPolygon(x_Co_ords, y_Co_ords, 3);
                graphics2d.setStroke(new BasicStroke(5));
                graphics2d.setColor(shape.secondary_Color);
                graphics2d.drawPolygon(x_Co_ords, y_Co_ords, 3);
                break;

            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }
}



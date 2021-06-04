package model.shapeManipulation;

import view.gui.Paint_Canvas;

import java.awt.*;

public class Draw_Shape implements IShape_Observer {

    static Graphics2D graphics2d;
    static Draw_Shape draw_Shape;
    static Master_List masterList;
    Paint_Canvas canvas;

    public Draw_Shape(Paint_Canvas canvas) {
        graphics2d = canvas.getGraphics2D();
    }

    public static void draw_Shape_Strategy(Create_Shape shape, Draw_Shape drawShape) {
        I_Shape_Drawer shape_Strategy;

        switch (shape.shape_Type) {
            case ELLIPSE:
                shape_Strategy = new Ellipse_Strategy();
                break;
            case CIRCLE:
                shape_Strategy = new Circle_Strategy();
                break;
            case TRIANGLE:
                shape_Strategy = new Triangle_Strategy();
                break;
            case RECTANGLE:
                shape_Strategy = new Rectangle_Strategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }

        shape_Strategy.draw(shape, graphics2d);

    }

    @Override
    public void update() {
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, 1200, 800);

        for (Create_Shape shape : ((Master_List) Manager_List.get_Master()).grab_List()) {
            draw_Shape_Strategy(shape, draw_Shape);
        }
    }
}

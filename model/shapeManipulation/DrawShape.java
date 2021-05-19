package model.shapeManipulation;

import view.gui.Paint_Canvas;

import java.awt.*;

public class DrawShape implements IShape_Observer {

    static Graphics2D graphics2d;
    static DrawShape drawShape;
    static Master_List masterList;
    Paint_Canvas canvas;

    public DrawShape(Paint_Canvas canvas) {
        graphics2d = canvas.getGraphics2D();
    }

    public static void drawShapeStrategy(CreateShape shape, DrawShape drawShape) {
        IShapeDrawer shapeStrategy;

        switch (shape.shapeType) {
            case ELLIPSE:
                shapeStrategy = new EllipseStrategy();
                break;
            case CIRCLE:
                shapeStrategy = new CircleStrategy();
                break;
            case TRIANGLE:
                shapeStrategy = new TriangleStrategy();
                break;
            case RECTANGLE:
                shapeStrategy = new RectangleStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }

        shapeStrategy.draw(shape, graphics2d);

    }

    @Override
    public void update() {
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, 1200, 800);

        for (CreateShape shape : ((Master_List) ListManager.getMaster()).grabList()) {
            drawShapeStrategy(shape, drawShape);
        }
    }
}

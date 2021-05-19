package controller.commands;

import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;
import view.gui.CustomPair;

import java.util.ArrayList;
import java.util.List;

public class MoveShape implements ICommand, IUndoable {

    static CreateShape newShape;
    static CreateShape oldShape;
    static List<CreateShape> newShapes = new ArrayList<>();
    static List<CreateShape> oldShapes = new ArrayList<>();
    private final CustomPair targetPair;


    public MoveShape(CustomPair targetPair) {
        this.targetPair = targetPair;
    }

    public static void moveCommand(CustomPair targetPair) {


        MoveShape toMove = new MoveShape(targetPair);

        for (CreateShape shape : (ListManager.getSelected().grabList())) {
            oldShape = shape;

            SelectShape boundingBox = SelectShape.getBoundingBox();
            CustomPair boundStart = boundingBox.boundStart;

            ListManager.getMaster().removeShape(oldShape);
            oldShapes.add(oldShape);

            int xDist = Math.abs(boundStart.X - shape.startingPair.X);
            int yDist = Math.abs(boundStart.Y - shape.startingPair.Y);

            int x1 = toMove.targetPair.X + xDist;
            int x2 = toMove.targetPair.X + xDist + shape.width;
            int y1 = toMove.targetPair.Y + yDist;
            int y2 = toMove.targetPair.Y + yDist + shape.height;

            CustomPair startPair = new CustomPair(x1, y1);
            CustomPair endPair = new CustomPair(x2, y2);

            int X = Math.min(x1, x2);
            int Y = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            newShape = new CreateShape(X, Y, startPair, endPair, height, width, shape.shapeConfig);

            ListManager.getMaster().addShape(newShape);
            newShapes.add(newShape);

        }
    }

    @Override
    public void run() {

        moveCommand(targetPair);
        CommandHistory.add(this);
        ListManager.getSelected().grabList().clear();

    }

    @Override
    public void undo() {

        for (CreateShape newOne : newShapes) {
            newShape = newOne;
            ListManager.getMaster().removeShape(newShape);
        }
        for (CreateShape oldOne : oldShapes) {
            oldShape = oldOne;
            ListManager.getMaster().addShape(oldShape);
        }
    }


    @Override
    public void redo() {

        for (CreateShape newOne : newShapes) {
            newShape = newOne;
            ListManager.getMaster().addShape(newShape);
        }
        for (CreateShape oldOne : oldShapes) {
            oldShape = oldOne;
            ListManager.getMaster().removeShape(oldShape);
        }
    }

}


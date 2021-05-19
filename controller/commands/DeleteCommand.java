package controller.commands;

import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;

import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoable {

    private static CreateShape shapeToDelete;
    private static ArrayList<CreateShape> deleteShapes = new ArrayList<CreateShape>();

    @Override
    public void run() {
        deleteShapes.clear();
        for (CreateShape shape : ListManager.getSelected().grabList()) {
            shapeToDelete = shape;
            ListManager.getMaster().removeShape(shapeToDelete);
            deleteShapes.add(shapeToDelete);

            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for (CreateShape shape : deleteShapes) {
            ListManager.getMaster().addShape(shape);
        }
    }

    @Override
    public void redo() {
        for (CreateShape shape : deleteShapes) {
            ListManager.getMaster().removeShape(shape);
        }
    }
}

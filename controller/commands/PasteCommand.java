package controller.commands;

import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;

import java.util.ArrayList;

public class PasteCommand implements ICommand, IUndoable {

    private static final ArrayList<CreateShape> pastedShapes = new ArrayList<>();
    static CreateShape shapeToPaste;

    @Override
    public void run() {
        for (CreateShape shape : ListManager.getClipBoard().grabList()) {
            shapeToPaste = shape;
            pastedShapes.add(shape);
            ListManager.getMaster().addShape(shapeToPaste);
            CommandHistory.add(this);
        }
        ListManager.getClipBoard().grabList().clear();
    }

    @Override
    public void undo() {
        for (CreateShape shapeToPaste : pastedShapes) {
            ListManager.getMaster().removeShape(shapeToPaste);
        }
    }

    @Override
    public void redo() {
        for (CreateShape shapeToPaste : pastedShapes) {
            ListManager.getMaster().addShape(shapeToPaste);
        }
    }
}

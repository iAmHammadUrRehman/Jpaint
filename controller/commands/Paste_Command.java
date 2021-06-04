package controller.commands;

import model.shapeManipulation.Create_Shape;
import model.shapeManipulation.Manager_List;

import java.util.ArrayList;

public class Paste_Command implements I_Command, I_Undoable {

    private static final ArrayList<Create_Shape> pastedShapes = new ArrayList<>();
    static Create_Shape shapes_To_Paste;

    @Override
    public void run() {
        for (Create_Shape shape : Manager_List.get_Clip_Board().grab_List()) {
            shapes_To_Paste = shape;
            pastedShapes.add(shape);
            Manager_List.get_Master().addShape(shapes_To_Paste);
            Command_History.add(this);
        }
        Manager_List.get_Clip_Board().grab_List().clear();
    }

    @Override
    public void undo() {
        for (Create_Shape shapes_To_Paste : pastedShapes) {
            Manager_List.get_Master().removeShape(shapes_To_Paste);
        }
    }

    @Override
    public void redo() {
        for (Create_Shape shapes_To_Paste : pastedShapes) {
            Manager_List.get_Master().addShape(shapes_To_Paste);
        }
    }
}

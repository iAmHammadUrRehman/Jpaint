package controller.commands;

import model.shapeManipulation.Create_Shape;
import model.shapeManipulation.Manager_List;

import java.util.ArrayList;

public class Delete_Command implements I_Command, I_Undoable {

    private static final ArrayList<Create_Shape> delete_Shapes = new ArrayList<Create_Shape>();
    private static Create_Shape shapes_To_Delete;

    @Override
    public void run() {
        delete_Shapes.clear();
        for (Create_Shape shape : Manager_List.get_Selected().grab_List()) {
            shapes_To_Delete = shape;
            Manager_List.get_Master().removeShape(shapes_To_Delete);
            delete_Shapes.add(shapes_To_Delete);

            Command_History.add(this);
        }
    }

    @Override
    public void undo() {
        for (Create_Shape shape : delete_Shapes) {
            Manager_List.get_Master().addShape(shape);
        }
    }

    @Override
    public void redo() {
        for (Create_Shape shape : delete_Shapes) {
            Manager_List.get_Master().removeShape(shape);
        }
    }
}

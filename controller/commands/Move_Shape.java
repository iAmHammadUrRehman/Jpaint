package controller.commands;

import model.shapeManipulation.Create_Shape;
import model.shapeManipulation.Manager_List;
import view.gui.Custom_Pair;

import java.util.ArrayList;
import java.util.List;

public class Move_Shape implements I_Command, I_Undoable {

    static Create_Shape new_Shape;
    static Create_Shape old_Shape;
    static List<Create_Shape> new_Shapes = new ArrayList<>();
    static List<Create_Shape> old_Shapes = new ArrayList<>();
    private final Custom_Pair target_Pair;


    public Move_Shape(Custom_Pair target_Pair) {
        this.target_Pair = target_Pair;
    }

    public static void move_Command(Custom_Pair target_Pair) {


        Move_Shape toMove = new Move_Shape(target_Pair);

        for (Create_Shape shape : (Manager_List.get_Selected().grab_List())) {
            old_Shape = shape;

            Select_Shape bounding_Box = Select_Shape.get_Bounding_Box();
            Custom_Pair boundStart = bounding_Box.bound_Start;

            Manager_List.get_Master().removeShape(old_Shape);
            old_Shapes.add(old_Shape);

            int x_Dist = Math.abs(boundStart.X - shape.starting_Pair.X);
            int y_Dist = Math.abs(boundStart.Y - shape.starting_Pair.Y);

            int x1 = toMove.target_Pair.X + x_Dist;
            int x2 = toMove.target_Pair.X + x_Dist + shape.width;
            int y1 = toMove.target_Pair.Y + y_Dist;
            int y2 = toMove.target_Pair.Y + y_Dist + shape.height;

            Custom_Pair start_Pair = new Custom_Pair(x1, y1);
            Custom_Pair end_Pair = new Custom_Pair(x2, y2);

            int X = Math.min(x1, x2);
            int Y = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            new_Shape = new Create_Shape(X, Y, start_Pair, end_Pair, height, width, shape.shape_Config);

            Manager_List.get_Master().addShape(new_Shape);
            new_Shapes.add(new_Shape);

        }
    }

    @Override
    public void run() {

        move_Command(target_Pair);
        Command_History.add(this);
        Manager_List.get_Selected().grab_List().clear();

    }

    @Override
    public void undo() {

        for (Create_Shape new_One : new_Shapes) {
            new_Shape = new_One;
            Manager_List.get_Master().removeShape(new_Shape);
        }
        for (Create_Shape old_One : old_Shapes) {
            old_Shape = old_One;
            Manager_List.get_Master().addShape(old_Shape);
        }
    }


    @Override
    public void redo() {

        for (Create_Shape new_One : new_Shapes) {
            new_Shape = new_One;
            Manager_List.get_Master().addShape(new_Shape);
        }
        for (Create_Shape old_One : old_Shapes) {
            old_Shape = old_One;
            Manager_List.get_Master().removeShape(old_Shape);
        }
    }

}


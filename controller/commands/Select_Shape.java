package controller.commands;

import model.shapeManipulation.Create_Shape;
import model.shapeManipulation.Manager_List;
import model.shapeManipulation.Master_List;
import view.gui.Custom_Pair;

public class Select_Shape implements I_Command {

    static Select_Shape bounding_Box;
    Custom_Pair bound_Start;
    Custom_Pair bound_End;

    public Select_Shape(Custom_Pair bound_Start, Custom_Pair bound_End) {
        this.bound_Start = bound_Start;
        this.bound_End = bound_End;
    }

    public static void select_Command(Custom_Pair boundStart, Custom_Pair boundEnd) {

        Manager_List.get_Selected().grab_List().clear();

        bounding_Box = new Select_Shape(boundStart, boundEnd);

        for (Create_Shape shape : ((Master_List) Manager_List.get_Master()).grab_List()) {
            if (bounding_Box.bound_Start.X < shape.starting_Pair.X && bounding_Box.bound_End.X > shape.ending_Pair.X
                    && bounding_Box.bound_Start.Y < shape.starting_Pair.Y && bounding_Box.bound_End.Y > shape.ending_Pair.Y) {
                Manager_List.get_Selected().addShape(shape);
            }
        }
    }

    public static Select_Shape get_Bounding_Box() {

        return bounding_Box;
    }

    @Override
    public void run() {


        select_Command(bound_Start, bound_End);
    }
}
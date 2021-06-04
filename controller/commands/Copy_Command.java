package controller.commands;

import model.Shape_Configuration;
import model.shapeManipulation.Create_Shape;
import model.shapeManipulation.Manager_List;
import view.gui.Custom_Pair;

public class Copy_Command implements I_Command {

    @Override
    public void run() {

        Manager_List.get_Clip_Board().grab_List().clear();


        for (Create_Shape shape : Manager_List.get_Selected().grab_List()) {

            int new_Start_X = shape.starting_Pair.X + 100;
            int new_Start_Y = shape.starting_Pair.Y + 100;
            Custom_Pair new_Start_Pair = new Custom_Pair(new_Start_X, new_Start_Y);

            int new_End_X = shape.ending_Pair.X + 100;
            int new_End_Y = shape.ending_Pair.Y + 100;
            Custom_Pair new_End_Pair = new Custom_Pair(new_End_X, new_End_Y);

            int new_Height = shape.height;
            int new_Width = shape.width;

            int new_X = Math.min(new_Start_X, new_End_X);
            int new_Y = Math.min(new_Start_Y, new_End_Y);

            Shape_Configuration new_Config = shape.shape_Config;

            Create_Shape copied_Shape = new Create_Shape(new_X, new_Y, new_Start_Pair, new_End_Pair,
                    new_Height, new_Width, new_Config);

            Manager_List.get_Clip_Board().addShape(copied_Shape);


        }

    }


}

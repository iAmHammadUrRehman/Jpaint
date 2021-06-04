package controller.commands;

import model.Shape_Configuration;
import model.shapeManipulation.Create_Shape;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import view.gui.Custom_Pair;

public class Command_Factory {


    @Contract("_, _, _, _, _, _, _ -> new")
    public static @NotNull I_Command draw_Command(int X, int Y, Custom_Pair startingPair, Custom_Pair endingPair,
                                                  int height, int width, Shape_Configuration shapeConfig) {
        return new Create_Shape(X, Y, startingPair, endingPair, height, width, shapeConfig);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static I_Command select_Command(Custom_Pair startPair, Custom_Pair endPair) {
        return new Select_Shape(startPair, endPair);
    }


    @Contract(value = "_ -> new", pure = true)
    public static @NotNull I_Command move_Command(Custom_Pair startingPair) {
        return new Move_Shape(startingPair);
    }
}

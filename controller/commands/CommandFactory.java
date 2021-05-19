package controller.commands;

import model.ShapeConfiguration;
import model.shapeManipulation.CreateShape;
import view.gui.CustomPair;

public class CommandFactory {


    public static ICommand drawCommand(int X, int Y, CustomPair startingPair, CustomPair endingPair,
                                       int height, int width, ShapeConfiguration shapeConfig) {
        return new CreateShape(X, Y, startingPair, endingPair, height, width, shapeConfig);
    }

    public static ICommand selectCommand(CustomPair startPair, CustomPair endPair) {
        return new SelectShape(startPair, endPair);
    }


    public static ICommand moveCommand(CustomPair startingPair) {
        return new MoveShape(startingPair);
    }
}

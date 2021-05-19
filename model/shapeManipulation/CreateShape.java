package model.shapeManipulation;

import controller.commands.CommandHistory;
import controller.commands.ICommand;
import controller.commands.IUndoable;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import view.gui.CustomPair;

import java.awt.*;

public class CreateShape implements ICommand, IUndoable {

    public ShapeConfiguration shapeConfig;
    public CustomPair startingPair;
    public CustomPair endingPair;
    public int height;
    public int width;
    CreateShape shape;
    Color primaryColor;
    Color secondaryColor;
    ShapeType shapeType;
    ShapeShadingType shadingType;
    int X;
    int Y;

    public CreateShape(int X, int Y, CustomPair startingPair, CustomPair endingPair,
                       int height, int width, ShapeConfiguration shapeConfig) {
        this.X = X;
        this.Y = Y;
        this.startingPair = startingPair;
        this.endingPair = endingPair;
        this.height = height;
        this.width = width;
        this.shapeConfig = shapeConfig;
        this.shapeType = shapeConfig.shapeType;
        this.primaryColor = shapeConfig.primaryColor.getColor();
        this.secondaryColor = shapeConfig.secondaryColor.getColor();
        this.shadingType = shapeConfig.shadingType;
    }

    @Override
    public void run() {
        shape = new CreateShape(X, Y, startingPair, endingPair, height, width, shapeConfig);
        ListManager.getMaster().addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ListManager.getMaster().removeShape(shape);
    }

    @Override
    public void redo() {
        ListManager.getMaster().addShape(shape);
    }
}


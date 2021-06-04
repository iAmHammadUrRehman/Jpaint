package model.shapeManipulation;

import controller.commands.Command_History;
import controller.commands.I_Command;
import controller.commands.I_Undoable;
import model.Shape_Configuration;
import model.Shape_Shading_Type;
import model.Shape_Type;
import view.gui.Custom_Pair;

import java.awt.*;

public class Create_Shape implements I_Command, I_Undoable {

    public Shape_Configuration shape_Config;
    public Custom_Pair starting_Pair;
    public Custom_Pair ending_Pair;
    public int height;
    public int width;
    Create_Shape shape;
    Color primary_Color;
    Color secondary_Color;
    Shape_Type shape_Type;
    Shape_Shading_Type shading_Type;
    int X;
    int Y;

    public Create_Shape(int X, int Y, Custom_Pair starting_Pair, Custom_Pair ending_Pair,
                        int height, int width, Shape_Configuration shape_Config) {
        this.X = X;
        this.Y = Y;
        this.starting_Pair = starting_Pair;
        this.ending_Pair = ending_Pair;
        this.height = height;
        this.width = width;
        this.shape_Config = shape_Config;
        this.shape_Type = shape_Config.shape_Type;
        this.primary_Color = shape_Config.primary_Color.get_Color();
        this.secondary_Color = shape_Config.secondary_Color.get_Color();
        this.shading_Type = shape_Config.shading_Type;
    }

    @Override
    public void run() {
        shape = new Create_Shape(X, Y, starting_Pair, ending_Pair, height, width, shape_Config);
        Manager_List.get_Master().addShape(shape);
        Command_History.add(this);
    }

    @Override
    public void undo() {
        Manager_List.get_Master().removeShape(shape);
    }

    @Override
    public void redo() {
        Manager_List.get_Master().addShape(shape);
    }
}


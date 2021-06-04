package view.gui;

import controller.commands.Shape_Command;
import model.Shape_Configuration;
import model.persistence.State_Application;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Click_Handler extends MouseAdapter {

    private static State_Application app_State;
    private Custom_Pair start_Pair;
    private Custom_Pair end_Pair;
    private int X;
    private int Y;
    private int height;
    private int width;

    public static void Grabber_State(State_Application state) {
        app_State = state;
    }

    public void mousePressed(MouseEvent e) {

        int x1 = e.getX();
        int y1 = e.getY();

        start_Pair = new Custom_Pair(x1, y1);

    }

    public void mouseReleased(MouseEvent e) {

        int x2 = e.getX();
        int y2 = e.getY();

        end_Pair = new Custom_Pair(x2, y2);


        X = Math.min(start_Pair.X, end_Pair.X);
        Y = Math.min(start_Pair.Y, end_Pair.Y);
        width = Math.abs(start_Pair.X - end_Pair.X);
        height = Math.abs(start_Pair.Y - end_Pair.Y);

        Shape_Configuration shape_Config = app_State.get_Current_Shape_Configuration();

        try {
            Shape_Command.command_Runner(X, Y, start_Pair, end_Pair, height, width, shape_Config);
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
    }
}








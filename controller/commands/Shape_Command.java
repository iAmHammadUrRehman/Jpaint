package controller.commands;

import model.Shape_Configuration;
import model.Start_And_End_Point_Mode;
import model.persistence.State_Application;
import view.gui.Custom_Pair;

import java.io.IOException;

public class Shape_Command {
    private static State_Application app_State;
    private static I_Command command;

    public static void command_Runner(int X, int Y, Custom_Pair startingPair,
                                      Custom_Pair endingPair, int height, int width,
                                      Shape_Configuration shapeConfig)
            throws IOException {

        Start_And_End_Point_Mode end_Point = app_State.get_Active_Start_And_EndPoint_Mode();

        switch (end_Point) {

            case DRAW:
                command = Command_Factory.draw_Command(X, Y, startingPair, endingPair, height, width, shapeConfig);
                break;
            case SELECT:
                command = Command_Factory.select_Command(startingPair, endingPair);
                break;
            case MOVE:
                command = Command_Factory.move_Command(startingPair);
                break;

            default:
                throw new IOException("No such command");
        }

        command.run();
    }

    public static void grab_End_point(State_Application state) {
        app_State = state;
    }
}



package view.gui;

import controller.commands.ShapeCommand;
import model.ShapeConfiguration;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ClickHandler extends MouseAdapter {

    private static ApplicationState appState;
    private CustomPair startPair;
    private CustomPair endPair;
    private int X;
    private int Y;
    private int height;
    private int width;

    public static void stateGrabber(ApplicationState state) {
        appState = state;
    }

    public void mousePressed(MouseEvent e) {

        int x1 = e.getX();
        int y1 = e.getY();

        startPair = new CustomPair(x1, y1);

    }

    public void mouseReleased(MouseEvent e) {

        int x2 = e.getX();
        int y2 = e.getY();

        endPair = new CustomPair(x2, y2);


        X = Math.min(startPair.X, endPair.X);
        Y = Math.min(startPair.Y, endPair.Y);
        width = Math.abs(startPair.X - endPair.X);
        height = Math.abs(startPair.Y - endPair.Y);

        ShapeConfiguration shapeConfig = appState.getCurrentShapeConfiguration();

        try {
            ShapeCommand.commandRunner(X, Y, startPair, endPair, height, width, shapeConfig);
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
    }
}








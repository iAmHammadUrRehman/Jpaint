package controller.commands;

import model.ShapeConfiguration;
import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;
import view.gui.CustomPair;

public class CopyCommand implements ICommand {

    @Override
    public void run() {

        ListManager.getClipBoard().grabList().clear();


        for (CreateShape shape : ListManager.getSelected().grabList()) {

            int newStartX = shape.startingPair.X + 100;
            int newStartY = shape.startingPair.Y + 100;
            CustomPair newStartPair = new CustomPair(newStartX, newStartY);

            int newEndX = shape.endingPair.X + 100;
            int newEndY = shape.endingPair.Y + 100;
            CustomPair newEndPair = new CustomPair(newEndX, newEndY);

            int newHeight = shape.height;
            int newWidth = shape.width;

            int newX = Math.min(newStartX, newEndX);
            int newY = Math.min(newStartY, newEndY);

            ShapeConfiguration newConfig = shape.shapeConfig;

            CreateShape copiedShape = new CreateShape(newX, newY, newStartPair, newEndPair,
                    newHeight, newWidth, newConfig);

            ListManager.getClipBoard().addShape(copiedShape);


        }

    }


}

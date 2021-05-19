package controller.commands;

import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;
import model.shapeManipulation.Master_List;
import view.gui.CustomPair;

public class SelectShape implements ICommand {

    static SelectShape boundingBox;
    CustomPair boundStart;
    CustomPair boundEnd;

    public SelectShape(CustomPair boundStart, CustomPair boundEnd) {
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
    }

    public static void selectCommand(CustomPair boundStart, CustomPair boundEnd) {

        ListManager.getSelected().grabList().clear();

        boundingBox = new SelectShape(boundStart, boundEnd);

        for (CreateShape shape : ((Master_List) ListManager.getMaster()).grabList()) {
            if (boundingBox.boundStart.X < shape.startingPair.X && boundingBox.boundEnd.X > shape.endingPair.X
                    && boundingBox.boundStart.Y < shape.startingPair.Y && boundingBox.boundEnd.Y > shape.endingPair.Y) {
                ListManager.getSelected().addShape(shape);
            }
        }
    }

    public static SelectShape getBoundingBox() {

        return boundingBox;
    }

    @Override
    public void run() {


        selectCommand(boundStart, boundEnd);
    }
}
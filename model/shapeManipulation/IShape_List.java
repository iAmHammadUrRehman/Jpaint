package model.shapeManipulation;

import java.util.List;

public interface IShape_List {

    void addShape(Create_Shape shape);

    void removeShape(Create_Shape shape);

    List<Create_Shape> grab_List();
}

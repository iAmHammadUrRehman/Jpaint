package model.shapeManipulation;

import java.util.List;

public interface IShapeList {

    void addShape(CreateShape shape);

    void removeShape(CreateShape shape);

    List<CreateShape> grabList();
}

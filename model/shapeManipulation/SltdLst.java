package model.shapeManipulation;

import java.util.List;

public class SltdLst implements IShape_List {

    public List<Create_Shape> shapeList;

    public SltdLst(List<Create_Shape> shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void addShape(Create_Shape shape) {
        shapeList.add(shape);
    }

    @Override
    public void removeShape(Create_Shape shape) {
        shapeList.remove(shape);
    }

    @Override
    public List<Create_Shape> grab_List() {
        return shapeList;
    }
}

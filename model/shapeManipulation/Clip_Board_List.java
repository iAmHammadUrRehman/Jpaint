package model.shapeManipulation;

import java.util.List;

public class Clip_Board_List implements IShape_List {

    public List<Create_Shape> shape_List;

    public Clip_Board_List(List<Create_Shape> shape_List) {
        this.shape_List = shape_List;
    }

    @Override
    public void addShape(Create_Shape shape) {
        shape_List.add(shape);
    }

    @Override
    public void removeShape(Create_Shape shape) {
        shape_List.remove(shape);
    }

    @Override
    public List<Create_Shape> grab_List() {
        return shape_List;
    }
}

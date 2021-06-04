package model.shapeManipulation;


import java.util.ArrayList;
import java.util.List;

public class Master_List implements IShape_Subject, IShape_List {

    private final List<IShape_Observer> observers = new ArrayList<IShape_Observer>();

    public List<Create_Shape> shape_List;

    public Master_List(List<Create_Shape> shape_List) {
        this.shape_List = shape_List;
    }

    @Override
    public void addShape(Create_Shape shape) {
        shape_List.add(shape);
        notify_Observers();
    }

    @Override
    public void removeShape(Create_Shape shape) {
        shape_List.remove(shape);
        notify_Observers();
    }

    @Override
    public void register_Observer(IShape_Observer observer) {
        observers.add(observer);
    }


    @Override
    public void notify_Observers() {
        for (IShape_Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public List<Create_Shape> grab_List() {
        return shape_List;
    }
}

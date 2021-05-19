package model.shapeManipulation;


import java.util.ArrayList;
import java.util.List;

public class Master_List implements IShape_Subject, IShapeList {

    private final List<IShape_Observer> observers = new ArrayList<IShape_Observer>();

    public List<CreateShape> shapeList;

    public Master_List(List<CreateShape> shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void addShape(CreateShape shape) {
        shapeList.add(shape);
        notifyObservers();
    }

    @Override
    public void removeShape(CreateShape shape) {
        shapeList.remove(shape);
        notifyObservers();
    }

    @Override
    public void registerObserver(IShape_Observer observer) {
        observers.add(observer);
    }


    @Override
    public void notifyObservers() {
        for (IShape_Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public List<CreateShape> grabList() {
        return shapeList;
    }
}

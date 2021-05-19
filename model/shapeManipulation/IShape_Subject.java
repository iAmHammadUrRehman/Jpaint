package model.shapeManipulation;

public interface IShape_Subject {

    void registerObserver(IShape_Observer observer);

    void notifyObservers();

    void addShape(CreateShape shape);

    void removeShape(CreateShape shape);

}

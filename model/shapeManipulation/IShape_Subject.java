package model.shapeManipulation;

public interface IShape_Subject {

    void register_Observer(IShape_Observer observer);

    void notify_Observers();

    void addShape(Create_Shape shape);

    void removeShape(Create_Shape shape);

}

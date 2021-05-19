package model.shapeManipulation;

public class ListManager {

    static ListManager manager;
    private static IShape_Subject masterList;
    private static IShapeList selectedList;
    private static IShapeList clipBoard;

    public ListManager(IShape_Subject masterList, IShapeList selectedList, IShapeList clipBoard) {
        ListManager.masterList = masterList;
        ListManager.selectedList = selectedList;
        ListManager.clipBoard = clipBoard;
    }

    public static IShape_Subject getMaster() {
        return masterList;
    }

    public static IShapeList getSelected() {
        return selectedList;
    }

    public static IShapeList getClipBoard() {
        return clipBoard;
    }

    public static void getManager(ListManager thisManager) {
        manager = thisManager;
    }
}

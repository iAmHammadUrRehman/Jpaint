package model.shapeManipulation;

public class Manager_List {

    static Manager_List manager;
    private static IShape_Subject master_List;
    private static IShape_List selected_List;
    private static IShape_List clip_Board;

    public Manager_List(IShape_Subject master_List, IShape_List selected_List, IShape_List clip_Board) {
        Manager_List.master_List = master_List;
        Manager_List.selected_List = selected_List;
        Manager_List.clip_Board = clip_Board;
    }

    public static IShape_Subject get_Master() {
        return master_List;
    }

    public static IShape_List get_Selected() {
        return selected_List;
    }

    public static IShape_List get_Clip_Board() {
        return clip_Board;
    }

    public static void get_Manager(Manager_List thisManager) {
        manager = thisManager;
    }
}

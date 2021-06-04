package main;

import controller.IJ_Paint_Controller;
import controller.J_Paint_Controller;
import controller.commands.Shape_Command;
import model.persistence.State_Application;
import model.shapeManipulation.*;
import view.gui.Click_Handler;
import view.gui.Gui;
import view.gui.Gui_Window;
import view.gui.Paint_Canvas;
import view.interfaces.I_Gui_Window;
import view.interfaces.I_Ui_Module;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("InstantiationOfUtilityClass")
public class Main {
    public static void main(String[] args) {

        var canvas = new Paint_Canvas();

        I_Gui_Window gui_Window = new Gui_Window(canvas);
        I_Ui_Module uiModule = new Gui(gui_Window);
        var state_App = new State_Application(uiModule);
        IJ_Paint_Controller cntrlr = new J_Paint_Controller(uiModule, state_App);
        cntrlr.setup();

        canvas.addMouseListener(new Click_Handler());
        Click_Handler.Grabber_State(state_App);
        Shape_Command.grab_End_point(state_App);

        final List<Create_Shape> mstr = new ArrayList<>();
        IShape_Subject master_list = new Master_List(mstr);
        IShape_Observer obsrvr = new Draw_Shape(canvas);
        master_list.register_Observer(obsrvr);

        final List<Create_Shape> selected = new ArrayList<>();
        IShape_List sltdLst = new SltdLst(selected);

        final List<Create_Shape> clipBoard = new ArrayList<>();
        IShape_List clpBrdLst = new SltdLst(clipBoard);

        var lst_Mngr = new Manager_List(master_list, sltdLst, clpBrdLst);
        Manager_List.get_Manager(lst_Mngr);
    }
}

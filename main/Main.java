package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.commands.ShapeCommand;
import model.persistence.ApplicationState;
import model.shapeManipulation.*;
import view.gui.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.Paint_Canvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("InstantiationOfUtilityClass")
public class Main {
    public static void main(String[] args) {

        var canvas = new Paint_Canvas();

        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        var appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        canvas.addMouseListener(new ClickHandler());
        ClickHandler.stateGrabber(appState);
        ShapeCommand.grabEndpoint(appState);

        final List<CreateShape> master = new ArrayList<>();
        IShape_Subject masterList = new Master_List(master);
        IShape_Observer observer = new DrawShape(canvas);
        masterList.registerObserver(observer);

        final List<CreateShape> selected = new ArrayList<>();
        IShapeList selectedList = new SelectedList(selected);

        final List<CreateShape> clipBoard = new ArrayList<>();
        IShapeList clipBoardList = new SelectedList(clipBoard);

        var listManager = new ListManager(masterList, selectedList, clipBoardList);
        ListManager.getManager(listManager);
    }
}

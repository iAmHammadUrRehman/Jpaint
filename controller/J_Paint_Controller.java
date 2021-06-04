package controller;

import controller.commands.*;
import model.interfaces.I_Application_State;
import view.Event_Name;
import view.interfaces.I_Ui_Module;

public class J_Paint_Controller implements IJ_Paint_Controller {
    private final I_Ui_Module ui_Module;
    private final I_Application_State application_State;

    public J_Paint_Controller(I_Ui_Module ui_Module, I_Application_State application_State) {
        this.ui_Module = ui_Module;
        this.application_State = application_State;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        ui_Module.add_Event(Event_Name.CHOOSE_SHAPE, application_State::set_Active_Shape);
        ui_Module.add_Event(Event_Name.CHOOSE_PRIMARY_COLOR, application_State::set_Active_Primary_Color);
        ui_Module.add_Event(Event_Name.CHOOSE_SECONDARY_COLOR, application_State::set_Active_Secondary_Color);
        ui_Module.add_Event(Event_Name.CHOOSE_SHADING_TYPE, application_State::set_Active_Shading_Type);
        ui_Module.add_Event(Event_Name.CHOOSE_START_POINT_ENDPOINT_MODE, application_State::set_Active_Start_And_EndPoint_Mode);
        ui_Module.add_Event(Event_Name.UNDO, () -> new Undo_Command().run());
        ui_Module.add_Event(Event_Name.REDO, () -> new Redo_Command().run());
        ui_Module.add_Event(Event_Name.COPY, () -> new Copy_Command().run());
        ui_Module.add_Event(Event_Name.PASTE, () -> new Paste_Command().run());
        ui_Module.add_Event(Event_Name.DELETE, () -> new Delete_Command().run());

    }
}

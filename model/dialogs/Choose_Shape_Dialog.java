package model.dialogs;

import model.Shape_Type;
import model.interfaces.I_Application_State;
import view.interfaces.I_Dialog_Choice;

public class Choose_Shape_Dialog implements I_Dialog_Choice<Shape_Type> {
    private final I_Application_State application_State;

    public Choose_Shape_Dialog(I_Application_State application_State) {

        this.application_State = application_State;
    }

    @Override
    public String get_Dialog_Title() {
        return "Shape";
    }

    @Override
    public String get_Dialog_Text() {
        return "Select a shape from the menu below:";
    }

    @Override
    public Shape_Type[] get_Dialog_Options() {
        return Shape_Type.values();
    }

    @Override
    public Shape_Type get_Current_Selection() {
        return application_State.get_Active_Shape_Type();
    }
}

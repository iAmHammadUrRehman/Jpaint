package model.dialogs;

import model.Shape_Shading_Type;
import model.interfaces.I_Application_State;
import view.interfaces.I_Dialog_Choice;

public class Choose_Shading_Type_Dialog implements I_Dialog_Choice<Shape_Shading_Type> {
    private final I_Application_State application_State;

    public Choose_Shading_Type_Dialog(I_Application_State application_State) {

        this.application_State = application_State;
    }

    @Override
    public String get_Dialog_Title() {
        return "Shading Type";
    }

    @Override
    public String get_Dialog_Text() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public Shape_Shading_Type[] get_Dialog_Options() {
        return Shape_Shading_Type.values();
    }

    @Override
    public Shape_Shading_Type get_Current_Selection() {
        return application_State.get_Active_Shape_Shading_Type();
    }
}

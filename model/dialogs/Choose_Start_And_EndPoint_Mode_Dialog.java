package model.dialogs;

import model.Start_And_End_Point_Mode;
import model.interfaces.I_Application_State;
import view.interfaces.I_Dialog_Choice;

public class Choose_Start_And_EndPoint_Mode_Dialog implements I_Dialog_Choice<Start_And_End_Point_Mode> {
    private final I_Application_State application_State;

    public Choose_Start_And_EndPoint_Mode_Dialog(I_Application_State application_State) {

        this.application_State = application_State;
    }

    @Override
    public String get_Dialog_Title() {
        return "Start and End Point Mode";
    }

    @Override
    public String get_Dialog_Text() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public Start_And_End_Point_Mode[] get_Dialog_Options() {
        return Start_And_End_Point_Mode.values();
    }

    @Override
    public Start_And_End_Point_Mode get_Current_Selection() {
        return application_State.get_Active_Start_And_EndPoint_Mode();
    }
}

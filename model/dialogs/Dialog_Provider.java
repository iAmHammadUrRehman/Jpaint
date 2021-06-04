package model.dialogs;

import model.Color_Adapter;
import model.Shape_Shading_Type;
import model.Shape_Type;
import model.Start_And_End_Point_Mode;
import model.interfaces.I_Application_State;
import model.interfaces.I_Dialog_Provider;
import view.interfaces.I_Dialog_Choice;

public class Dialog_Provider implements I_Dialog_Provider {
    private final I_Dialog_Choice<Shape_Type> choose_Shape_Dialog;
    private final I_Dialog_Choice<Color_Adapter> choose_Primary_Color_Dialog;
    private final I_Dialog_Choice<Color_Adapter> choose_Secondary_Color_Dialog;
    private final I_Dialog_Choice<Shape_Shading_Type> choose_Shading_Type_Dialog;
    private final I_Dialog_Choice<Start_And_End_Point_Mode> choose_Start_And_EndPoint_Mode_Dialog;
    private final I_Application_State application_State;

    public Dialog_Provider(I_Application_State application_State) {
        this.application_State = application_State;
        choose_Shape_Dialog = new Choose_Shape_Dialog(this.application_State);
        choose_Primary_Color_Dialog = new Choose_Primary_Color_Dialog(this.application_State);
        choose_Secondary_Color_Dialog = new Choose_Secondary_Color_Dialog(this.application_State);
        choose_Shading_Type_Dialog = new Choose_Shading_Type_Dialog(this.application_State);
        choose_Start_And_EndPoint_Mode_Dialog = new Choose_Start_And_EndPoint_Mode_Dialog(this.application_State);
    }

    @Override
    public I_Dialog_Choice<Shape_Type> getChoose_Shape_Dialog() {
        return choose_Shape_Dialog;
    }

    @Override
    public I_Dialog_Choice<Color_Adapter> getChoose_Primary_Color_Dialog() {
        return choose_Primary_Color_Dialog;
    }

    @Override
    public I_Dialog_Choice<Color_Adapter> getChoose_Secondary_Color_Dialog() {
        return choose_Secondary_Color_Dialog;
    }

    @Override
    public I_Dialog_Choice<Shape_Shading_Type> getChoose_Shading_Type_Dialog() {
        return choose_Shading_Type_Dialog;
    }

    @Override
    public I_Dialog_Choice<Start_And_End_Point_Mode> getChoose_Start_And_EndPoint_Mode_Dialog() {
        return choose_Start_And_EndPoint_Mode_Dialog;
    }
}

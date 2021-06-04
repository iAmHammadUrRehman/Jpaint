package model.interfaces;

import model.Color_Adapter;
import model.Shape_Shading_Type;
import model.Shape_Type;
import model.Start_And_End_Point_Mode;
import view.interfaces.I_Dialog_Choice;

public interface I_Dialog_Provider {

    I_Dialog_Choice<Shape_Type> getChoose_Shape_Dialog();

    I_Dialog_Choice<Color_Adapter> getChoose_Primary_Color_Dialog();

    I_Dialog_Choice<Color_Adapter> getChoose_Secondary_Color_Dialog();

    I_Dialog_Choice<Shape_Shading_Type> getChoose_Shading_Type_Dialog();

    I_Dialog_Choice<Start_And_End_Point_Mode> getChoose_Start_And_EndPoint_Mode_Dialog();
}

package model.interfaces;

import model.Color_Adapter;
import model.Shape_Shading_Type;
import model.Shape_Type;
import model.Start_And_End_Point_Mode;

public interface I_Application_State {
    void set_Active_Shape();

    void set_Active_Primary_Color();

    void set_Active_Secondary_Color();

    void set_Active_Shading_Type();

    void set_Active_Start_And_EndPoint_Mode();

    Shape_Type get_Active_Shape_Type();

    Color_Adapter get_Active_Primary_Color();

    Color_Adapter get_Active_Secondary_Color();

    Shape_Shading_Type get_Active_Shape_Shading_Type();

    Start_And_End_Point_Mode get_Active_Start_And_EndPoint_Mode();
}

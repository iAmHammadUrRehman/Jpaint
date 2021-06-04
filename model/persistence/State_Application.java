package model.persistence;

import model.*;
import model.dialogs.Dialog_Provider;
import model.interfaces.I_Application_State;
import model.interfaces.I_Dialog_Provider;
import view.interfaces.I_Ui_Module;

import java.awt.*;

public class State_Application implements I_Application_State {
    private final I_Ui_Module ui_Module;
    private final I_Dialog_Provider dialog_Provider;

    private Shape_Type active_Shape_Type;
    private Color_Adapter active_Primary_Color;
    private Color_Adapter active_Secondary_Color;
    private Shape_Shading_Type active_Shape_Shading_Type;
    private Start_And_End_Point_Mode active_Start_And_EndPoint_Mode;

    public State_Application(I_Ui_Module ui_Module) {
        this.ui_Module = ui_Module;
        this.dialog_Provider = new Dialog_Provider(this);
        set_Defaults();
    }

    @Override
    public void set_Active_Shape() {
        active_Shape_Type = ui_Module.get_Dialog_Response(dialog_Provider.getChoose_Shape_Dialog());
    }

    @Override
    public void set_Active_Primary_Color() {
        active_Primary_Color = ui_Module.get_Dialog_Response(dialog_Provider.getChoose_Primary_Color_Dialog());
    }

    @Override
    public void set_Active_Secondary_Color() {
        active_Secondary_Color = ui_Module.get_Dialog_Response(dialog_Provider.getChoose_Secondary_Color_Dialog());
    }

    @Override
    public void set_Active_Shading_Type() {
        active_Shape_Shading_Type = ui_Module.get_Dialog_Response(dialog_Provider.getChoose_Shading_Type_Dialog());
    }

    @Override
    public void set_Active_Start_And_EndPoint_Mode() {
        active_Start_And_EndPoint_Mode = ui_Module.get_Dialog_Response(dialog_Provider.getChoose_Start_And_EndPoint_Mode_Dialog());
    }

    @Override
    public Shape_Type get_Active_Shape_Type() {
        return active_Shape_Type;
    }

    @Override
    public Color_Adapter get_Active_Primary_Color() {
        return active_Primary_Color;
    }

    @Override
    public Color_Adapter get_Active_Secondary_Color() {
        return active_Secondary_Color;
    }

    @Override
    public Shape_Shading_Type get_Active_Shape_Shading_Type() {
        return active_Shape_Shading_Type;
    }

    @Override
    public Start_And_End_Point_Mode get_Active_Start_And_EndPoint_Mode() {
        return active_Start_And_EndPoint_Mode;
    }

    public Shape_Configuration get_Current_Shape_Configuration() {
        return new Shape_Configuration(active_Primary_Color,
                active_Secondary_Color, active_Shape_Type,
                active_Shape_Shading_Type);
    }

    private void set_Defaults() {
        active_Shape_Type = Shape_Type.ELLIPSE;
        active_Primary_Color = new Color_Adapter(Color.BLUE, Shape_Color.BLUE);
        active_Secondary_Color = new Color_Adapter(Color.GREEN, Shape_Color.GREEN);
        active_Shape_Shading_Type = Shape_Shading_Type.FILLED_IN;
        active_Start_And_EndPoint_Mode = Start_And_End_Point_Mode.DRAW;
    }
}

package model.dialogs;

import model.Color_Adapter;
import model.Shape_Color;
import model.interfaces.I_Application_State;
import view.interfaces.I_Dialog_Choice;

import java.awt.*;
import java.util.ArrayList;

public class Choose_Primary_Color_Dialog implements I_Dialog_Choice<Color_Adapter> {

    private final I_Application_State application_State;
    private final ArrayList<Color_Adapter> colors;

    public Choose_Primary_Color_Dialog(I_Application_State application_State) {
        this.application_State = application_State;
        colors = new ArrayList<Color_Adapter>();
        colors.add(new Color_Adapter(Color.BLACK, Shape_Color.BLACK));
        colors.add(new Color_Adapter(Color.BLUE, Shape_Color.BLUE));
        colors.add(new Color_Adapter(Color.CYAN, Shape_Color.CYAN));
        colors.add(new Color_Adapter(Color.DARK_GRAY, Shape_Color.DARK_GRAY));
        colors.add(new Color_Adapter(Color.GRAY, Shape_Color.GRAY));
        colors.add(new Color_Adapter(Color.GREEN, Shape_Color.GREEN));
        colors.add(new Color_Adapter(Color.LIGHT_GRAY, Shape_Color.LIGHT_GRAY));
        colors.add(new Color_Adapter(Color.MAGENTA, Shape_Color.MAGENTA));
        colors.add(new Color_Adapter(Color.ORANGE, Shape_Color.ORANGE));
        colors.add(new Color_Adapter(Color.PINK, Shape_Color.PINK));
        colors.add(new Color_Adapter(Color.RED, Shape_Color.RED));
        colors.add(new Color_Adapter(Color.WHITE, Shape_Color.WHITE));
        colors.add(new Color_Adapter(Color.YELLOW, Shape_Color.YELLOW));
    }

    @Override
    public String get_Dialog_Title() {
        return "Primary Color";
    }

    @Override
    public String get_Dialog_Text() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public Color_Adapter[] get_Dialog_Options() {
        return colors.toArray(new Color_Adapter[0]);
    }

    @Override
    public Color_Adapter get_Current_Selection() {
        return application_State.get_Active_Primary_Color();
    }
}

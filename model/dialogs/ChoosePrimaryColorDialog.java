package model.dialogs;

import model.ColorAdapter;
import model.ShapeColor;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

import java.awt.*;
import java.util.ArrayList;

public class ChoosePrimaryColorDialog implements IDialogChoice<ColorAdapter> {

    private final IApplicationState applicationState;
    private final ArrayList<ColorAdapter> colors;

    public ChoosePrimaryColorDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
        colors = new ArrayList<ColorAdapter>();
        colors.add(new ColorAdapter(Color.BLACK, ShapeColor.BLACK));
        colors.add(new ColorAdapter(Color.BLUE, ShapeColor.BLUE));
        colors.add(new ColorAdapter(Color.CYAN, ShapeColor.CYAN));
        colors.add(new ColorAdapter(Color.DARK_GRAY, ShapeColor.DARK_GRAY));
        colors.add(new ColorAdapter(Color.GRAY, ShapeColor.GRAY));
        colors.add(new ColorAdapter(Color.GREEN, ShapeColor.GREEN));
        colors.add(new ColorAdapter(Color.LIGHT_GRAY, ShapeColor.LIGHT_GRAY));
        colors.add(new ColorAdapter(Color.MAGENTA, ShapeColor.MAGENTA));
        colors.add(new ColorAdapter(Color.ORANGE, ShapeColor.ORANGE));
        colors.add(new ColorAdapter(Color.PINK, ShapeColor.PINK));
        colors.add(new ColorAdapter(Color.RED, ShapeColor.RED));
        colors.add(new ColorAdapter(Color.WHITE, ShapeColor.WHITE));
        colors.add(new ColorAdapter(Color.YELLOW, ShapeColor.YELLOW));
    }

    @Override
    public String getDialogTitle() {
        return "Primary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public ColorAdapter[] getDialogOptions() {
        return colors.toArray(new ColorAdapter[0]);
    }

    @Override
    public ColorAdapter getCurrentSelection() {
        return applicationState.getActivePrimaryColor();
    }
}

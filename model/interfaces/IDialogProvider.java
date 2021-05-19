package model.interfaces;

import model.ColorAdapter;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ColorAdapter> getChoosePrimaryColorDialog();

    IDialogChoice<ColorAdapter> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
}

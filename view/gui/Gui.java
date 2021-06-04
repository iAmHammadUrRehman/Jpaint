package view.gui;

import view.Event_Name;
import view.interfaces.I_Dialog_Choice;
import view.interfaces.I_Event_Callback;
import view.interfaces.I_Gui_Window;
import view.interfaces.I_Ui_Module;

import javax.swing.*;

public class Gui implements I_Ui_Module {

    private final I_Gui_Window gui;

    public Gui(I_Gui_Window gui) {
        this.gui = gui;
    }

    @Override
    public void add_Event(Event_Name event_Name, I_Event_Callback call_back) {
        JButton button = gui.get_Button(event_Name);
        button.addActionListener((ActionEvent) -> call_back.run());
    }

    @Override
    public <T> T get_Dialog_Response(I_Dialog_Choice dialog_Choice) {
        Object selected_Value = JOptionPane.showInputDialog(null,
                dialog_Choice.get_Dialog_Text(), dialog_Choice.get_Dialog_Title(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialog_Choice.get_Dialog_Options(),
                dialog_Choice.get_Current_Selection());
        return selected_Value == null
                ? (T) dialog_Choice.get_Current_Selection()
                : (T) selected_Value;
    }
}

package view.interfaces;

import view.Event_Name;

public interface I_Ui_Module {
    void add_Event(Event_Name event_Name, I_Event_Callback command);

    <T> T get_Dialog_Response(I_Dialog_Choice dialog_Choice);
}

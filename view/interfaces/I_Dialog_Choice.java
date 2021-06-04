package view.interfaces;

public interface I_Dialog_Choice<T> {
    String get_Dialog_Title();

    String get_Dialog_Text();

    T[] get_Dialog_Options();

    T get_Current_Selection();
}

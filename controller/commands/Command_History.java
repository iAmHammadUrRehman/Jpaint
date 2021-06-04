package controller.commands;

import java.util.Stack;

public class Command_History {

    private static final Stack<I_Undoable> undo_Stack = new Stack<I_Undoable>();
    private static final Stack<I_Undoable> redo_Stack = new Stack<I_Undoable>();

    public static void add(I_Undoable cmd) {
        undo_Stack.push(cmd);
        redo_Stack.clear();
    }

    public static boolean undo() {

        boolean result = !undo_Stack.empty();
        if (result) {
            I_Undoable c = undo_Stack.pop();

            redo_Stack.push(c);
            c.undo();
        }
        return result;
    }

    public static boolean redo() {

        boolean result = !redo_Stack.empty();

        if (result) {
            I_Undoable c = redo_Stack.pop();
            undo_Stack.push(c);
            c.redo();
        }
        return result;
    }

}




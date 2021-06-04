package controller.commands;

public class Undo_Command implements I_Command {

    @Override
    public void run() {
        Command_History.undo();
    }
}

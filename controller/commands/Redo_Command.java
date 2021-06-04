package controller.commands;

public class Redo_Command implements I_Command {

    @Override
    public void run() {
        Command_History.redo();
    }
}

package gr.teicm.game.command;

import gr.teicm.game.model.Command;

public class HelpCommand implements ICommand {
    @Override
    public void perform() {
        String string = "";

        string += "I think you asked for my help...\n";
        string += "well...\n\n";
        string += "Your available command words are:\n";

        for (Command command : Command.values()) {
            string += "\t" + command + "\n";
        }

        System.out.println(string.trim());
    }
}

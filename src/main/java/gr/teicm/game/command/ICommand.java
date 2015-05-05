package gr.teicm.game.command;

import gr.teicm.game.exception.InvalidCommandArgumentException;

public interface ICommand {
    void perform() throws InvalidCommandArgumentException;
}

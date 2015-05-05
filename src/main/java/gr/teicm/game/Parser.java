package gr.teicm.game;

import gr.teicm.game.command.*;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.exception.InvalidCommandException;
import gr.teicm.game.model.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    private static Parser instance;

    private Parser() {
    }

    public static Parser getInstance() {
        if (instance == null) {
            instance = new Parser();
        }

        return instance;
    }

    public List<ICommand> parseCommands(String input) throws InvalidCommandException, InvalidCommandArgumentException {
        List<ICommand> commands = new ArrayList<>();

        String[] commandsSplit = input.split(" and ");

        List<String> words;
        StringTokenizer tokenizer;

        for (String commandInput : commandsSplit) {
            tokenizer = new StringTokenizer(commandInput);
            words = new ArrayList<>();

            while (tokenizer.hasMoreElements()) {
                words.add(tokenizer.nextToken());
            }

            Command representativeCommand = null;

            for (Command command : Command.values()) {
                try {
                    if (words.get(0).equalsIgnoreCase(command.toString())) {
                        representativeCommand = command;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new InvalidCommandException("No command found");
                }
            }

            if (representativeCommand != null) {
                if (representativeCommand == Command.GO) {
                    try {
                        commands.add(new GoCommand(words.get(1)));
                    } catch (IndexOutOfBoundsException e) {
                        throw new InvalidCommandArgumentException("No argument found");
                    }
                } else if (representativeCommand == Command.STATUS) {
                    commands.add(new StatusCommand());
                } else if (representativeCommand == Command.HELP) {
                    commands.add(new HelpCommand());
                } else if (representativeCommand == Command.QUIT) {
                    commands.add(new QuitCommand());
                }
                  else if (representativeCommand == Command.PICK){
                    commands.add(new PickCommand(words.get(1)));
                }
                else if(representativeCommand==Command.PRINT){
                    commands.add(new PrintRoomItems());
                }
            } else {
                throw new InvalidCommandException("There is no such command: " + words.get(0));
            }
        }

        return commands;
    }
}

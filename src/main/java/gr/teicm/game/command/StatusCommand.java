package gr.teicm.game.command;

import gr.teicm.game.PlayerState;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.model.Exit;
import gr.teicm.game.model.Item;
import gr.teicm.game.model.Room;

import java.util.ArrayList;
import java.util.LinkedList;

public class StatusCommand implements ICommand {
    private PlayerState playerState;
    private LinkedList<Item> PlayerItems =new LinkedList<>();

    public StatusCommand() {
        this.playerState = PlayerState.getInstance();
        PlayerItems=playerState.getItems();
    }

    @Override
    public void perform() throws InvalidCommandArgumentException {
        Room currentRoom = this.playerState.getCurrentRoom();

        String string = "";

        string += "Room: " + currentRoom.getName() + "\n";
        string += "Room Description: " + currentRoom.getfullDescription() + "\n";
        string += "Exits: \n";

        for (Exit exit : currentRoom.getExits()) {
            string += "\t" + exit.getDirection().toString() + "\t->\t" + exit.getRoom().getName() + "\n";
        }

        System.out.println(string.trim());

        System.out.println("Inventory :\n");
        if (PlayerItems.isEmpty())
            System.out.println("You dont have items on your inventory");
        else {
            System.out.println("Your inventory has the following items:");
            for (Item item : PlayerItems) {
                System.out.println(item.getItemName());
            }
        }

    }
}

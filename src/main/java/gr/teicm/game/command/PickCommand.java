package gr.teicm.game.command;

import gr.teicm.game.PlayerState;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.model.Item;
import gr.teicm.game.model.Room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by SqlAccount on 30/4/2015.
 */
public class PickCommand implements ICommand {

    private String arguments;

    public PickCommand(String arguments) {
        this.arguments = arguments;
        this.playerState = PlayerState.getInstance();
    }

    private PlayerState playerState;


    //        private String description;
    private boolean flag = false;


    public void perform() throws InvalidCommandArgumentException {

        Room currentRoom = playerState.getCurrentRoom();
        LinkedList<Item> RoomItems = currentRoom.getItems();

        Iterator<Item> ItemsRooms = RoomItems.iterator();
        while (ItemsRooms.hasNext()) {
            Item item = ItemsRooms.next();
            if (item.getItemName().equalsIgnoreCase(this.arguments)) {

                playerState.addItem(item);

                currentRoom.removeItem(item);
                flag = true;
            }


        }
        if(!flag)

        {
            throw new InvalidCommandArgumentException("there isnt any item with this name on the room");
        }
    }


}




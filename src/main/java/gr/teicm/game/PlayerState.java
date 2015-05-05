package gr.teicm.game;

import gr.teicm.game.model.Item;
import gr.teicm.game.model.Room;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayerState {
    private static PlayerState instance;

    private Room currentRoom;
    private LinkedList<Item> items;

    private PlayerState() {
        items = new LinkedList<>();
    }

    public static PlayerState getInstance() {
        if (instance == null) {
            instance = new PlayerState();
        }

        return instance;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}

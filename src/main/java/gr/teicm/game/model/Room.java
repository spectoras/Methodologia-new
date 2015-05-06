package gr.teicm.game.model;

import gr.teicm.game.PlayerState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private String fullDescription;
    private List<Exit> exits;
    private LinkedList<Item> items;
    private String string;
    private PlayerState playerState;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.fullDescription = "";
        this.exits = new ArrayList<>();
        this.items = new LinkedList<>();
        this.playerState=PlayerState.getInstance();
    }

    public List<Exit> getExits() {
        return this.exits;
    }

    public void addExits(Exit... exits) {
        Collections.addAll(this.exits, exits);
    }

    public String getDescription() {

        return description;
    }

    public String getfullDescription() {
        fullDescription = description;
        for (Item item : items) {
            if (!fullDescription.contains(item.getItemDescription()))
                fullDescription += item.getItemDescription();
        }
        return fullDescription;
    }

    public void addItem(Item item) {


        items.add(item);
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void removeItem(Item item) {

        items.remove(item);
        if(description.contains(item.getItemDescription()))
            description.replaceAll(item.getItemDescription(),"");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


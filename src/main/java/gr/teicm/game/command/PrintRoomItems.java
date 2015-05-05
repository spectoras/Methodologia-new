package gr.teicm.game.command;

import gr.teicm.game.PlayerState;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.model.Item;
import gr.teicm.game.model.Room;

import java.util.LinkedList;

/**
 * Created by SqlAccount on 5/5/2015.
 */
public class PrintRoomItems implements ICommand{

    private PlayerState playerState;
    private LinkedList<Item> items=new LinkedList();


    public PrintRoomItems(){
        this.playerState=PlayerState.getInstance();
        items=playerState.getCurrentRoom().getItems();

    }
    @Override
    public void perform() throws InvalidCommandArgumentException {
        if(items.isEmpty()){
            System.out.println("The room dont have items ");
        }
        else {
            for (Item item : items) {
                System.out.println(item.getItemName());
            }
        }
    }
}

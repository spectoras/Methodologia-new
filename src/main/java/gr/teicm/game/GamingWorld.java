package gr.teicm.game;

import gr.teicm.game.command.ICommand;
import gr.teicm.game.exception.InvalidCommandArgumentException;
import gr.teicm.game.exception.InvalidCommandException;
import gr.teicm.game.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamingWorld {
    private PlayerState playerState;
    private Parser parser;



    public GamingWorld() {

        this.playerState = PlayerState.getInstance();
        this.parser = Parser.getInstance();
        createAndLoadRooms();


    }
    Room yard,
         livingRoom;

    public void createAndLoadRooms() {
        Room yard = new Room("Yard", "You are at the house yard. It's beautiful out here although the weather is freezing cold!");
        Room livingRoom = new Room("Living Room", "You are in the living room. As you enter the house you feel the cozy warmth of the fireplace. ");
        Room kitchen = new Room("Kitchen", "The smell of fresh food indicates with closed eyes that this room is the kitchen.");
        Room bedroom = new Room("Bedroom", "This is where le sexy time happens... or where you can just sleep.");
        Room office = new Room("Office", "There is a huge desk as you enter the office. An Apple computer is on it. Also there is a big library with a plethora o books.");
        Room bathroom = new Room("Bathroom", "This bathroom is full of steam. You also distinguish rem stains on the mirror.");
        Room garage = new Room("Garage", "The garage seems pretty tidy. I wonder where the car could possibly be...");




        yard.addExits(new Exit(Direction.NORTH, livingRoom), new Exit(Direction.EAST, garage));
        livingRoom.addExits(new Exit(Direction.NORTH, bedroom), new Exit(Direction.EAST, kitchen), new Exit(Direction.SOUTH, yard), new Exit(Direction.WEST, office));
        livingRoom.addItem(new Item("dagger","a dagger is on the floor", ItemType.MISC,true,"Bedroom"));


        kitchen.addExits(new Exit(Direction.SOUTH, garage), new Exit(Direction.WEST, livingRoom));
        bedroom.addExits(new Exit(Direction.SOUTH, livingRoom), new Exit(Direction.WEST, bathroom));
        office.addExits(new Exit(Direction.NORTH, bathroom), new Exit(Direction.EAST, livingRoom));
        bathroom.addExits(new Exit(Direction.EAST, bedroom), new Exit(Direction.SOUTH, office));
        garage.addExits(new Exit(Direction.NORTH, kitchen), new Exit(Direction.WEST, yard));




        this.playerState.setCurrentRoom(yard);
    }
//    public void createItems(){
//        Item dagger=new Item("dagger","a dagger is on the floor", ItemType.MISC,true,"Bedroom");
//        playerState.addItem(dagger);
//    }

    public void play() {
        System.out.println(this.playerState.getCurrentRoom().getDescription());

        List<ICommand> commands;

        while (true) {
            try {
                System.out.print("> ");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                commands = parser.parseCommands(input);
                commands.forEach(ICommand::perform);
            } catch (InvalidCommandException | InvalidCommandArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

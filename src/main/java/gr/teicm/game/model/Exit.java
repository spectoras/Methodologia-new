package gr.teicm.game.model;

public class Exit {
    private Direction direction;
    private Room room;

    public Exit(Direction direction, Room room) {
        this.direction = direction;
        this.room = room;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

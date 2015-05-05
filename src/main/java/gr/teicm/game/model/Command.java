package gr.teicm.game.model;

public enum Command {
    GO("go"),
    STATUS("status"),
    HELP("help"),
    QUIT("quit"),
    PICK("pick"),
    PRINT("print");

    String value;

    Command(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

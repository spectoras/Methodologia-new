package gr.teicm.game.command;

public class QuitCommand implements ICommand {
    @Override
    public void perform() {
        System.out.println("Thank you for playing. Good bye.");
        System.exit(0);
    }
}

package gr.teicm.game;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println("Type 'help' if you need help.");
        System.out.println();

        GamingWorld game = new GamingWorld();
        game.play();
    }
}

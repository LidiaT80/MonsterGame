
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game=new Game();
        GameWindow window=new GameWindow();
        InputProcessor input=new InputProcessor();

        while (true) {
            input.menu(window,game);
            game=new Game();
            game.gameLoop(game, window, input);
        }

    }

}

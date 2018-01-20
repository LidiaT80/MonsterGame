import com.googlecode.lanterna.input.Key;


public class InputProcessor {

    Key key;

    public Key readKey(GameWindow window) throws InterruptedException{
        do{
            Thread.sleep(250);
            key =window.terminal.readInput();
        }
        while(key == null);
        return key;
    }

    public String movementKey(GameWindow window) throws InterruptedException {
        String movement;

        key=readKey(window);
        switch (key.getKind()){
            case ArrowDown:
               movement="down";
                break;
            case ArrowUp:
               movement="up";
                break;
            case ArrowLeft:
               movement="left";
                break;
            case ArrowRight:
                movement="right";
                break;
            case Escape:
                movement="out";
                break;
            default:
                movement="wrongKey";
                break;
        }
        return movement;

    }

    public void startKey( GameWindow window) throws InterruptedException {
        boolean loop=true;
        while ( loop) {
            key = readKey(window);
            switch (key.getKind()) {

                case Escape:
                    window.closeWindow();
                    break;
                case Enter:
                    loop = false;
                    break;
            }
        }
    }

    public void menu(GameWindow window, Game game) throws InterruptedException{

        window.terminal.clearScreen();
        window.printMessage( game.area," Press enter to start a new game, press escape to exit.");
        startKey( window);
    }
}

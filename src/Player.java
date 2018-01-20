
import com.googlecode.lanterna.terminal.Terminal;

public class Player extends GameObject{

    public Player(GameArea area){
        super(area);
    }


    public boolean movePlayer( InputProcessor input, GameWindow window) throws InterruptedException {

        boolean move = false;
        String movement = input.movementKey(window);

        switch (movement) {
            case "down":
                move =moveDown();
                break;
            case "up":
                move =moveUp();
                break;
            case "left":
                move =moveLeft();
                break;
            case "right":
                move =moveRight();
                break;
            case "out":
                window.closeWindow();
        }
        return move;
    }

}

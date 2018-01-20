import com.googlecode.lanterna.terminal.Terminal;
import java.util.Random;

public class GameObject {
    protected int x;
    protected int y;

    public GameObject(GameArea area){
        Random rd=new Random();
        x=rd.nextInt(area.getWidth()-2)+area.getStartX()+1; // 11-108
        y=rd.nextInt(area.getHeight()-2)+area.getStartY()+1; // 4-31
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }




    public boolean moveLeft(){
        if(x>10)
            x=x-1;
        return true;
    }
    public boolean moveRight(){
        if(x<88)
            x=x+1;
        return true;
    }
    public boolean moveUp(){
        if(y>4)
            y=y-1;
        return true;
    }
    public boolean moveDown(){
        if(y<26)
            y=y+1;
        return true;
    }


    public boolean move(GameObject player){
        return true;
    }

    public boolean movePlayer( InputProcessor input, GameWindow window) throws InterruptedException {
        return false;
    }
}

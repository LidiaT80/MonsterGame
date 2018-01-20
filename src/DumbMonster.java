import java.util.Random;

public class DumbMonster extends Monster {

    public DumbMonster(GameArea area){
        super(area);
    }


    public boolean move(GameObject player){
        boolean loop=true;
        int m;
        Random rd=new Random();
        m=rd.nextInt(4)+1;
        switch (m){
            case 1:
                moveRight();
                break;
            case 2:
                moveDown();
                break;
            case 3:
                moveLeft();
                break;
            case 4:
                moveUp();
                break;
        }


        if(x==player.getX() && y==player.getY())
            loop=false;

        return loop;
    }
}

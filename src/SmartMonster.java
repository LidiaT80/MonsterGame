

public class SmartMonster extends Monster {

    public SmartMonster(GameArea area){
        super(area);
    }



    public boolean move(GameObject player){

        boolean loop=true;
        if(Math.abs(x-player.getX())>Math.abs(y-player.getY())){
            if(x<player.getX())
                moveRight();
            else if (x>player.getX())
                moveLeft();
            else{
                if(y<player.getY())
                    moveDown();
                else if (y>player.getY())
                    moveUp();
                else
                    loop=false;
            }
        }
        else {
            if (y < player.getY())
                moveDown();
            else if (y>player.getY())
                moveUp();
            else {
                if(x<player.getX())
                    moveRight();
                else if (x>player.getX())
                    moveLeft();
                else
                    loop=false;
            }
        }
        if(x==player.getX() && y==player.getY())
            loop=false;

        return loop;

    }

}


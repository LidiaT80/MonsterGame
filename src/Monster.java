

public class Monster extends GameObject{

    public Monster(GameArea area){
        super(area);
    }


    public boolean move(GameObject player){
        return true;
    }
}

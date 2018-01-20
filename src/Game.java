
import java.util.Random;

public class Game {

    GameObject player;
    GameObject[] monsters;
    GameArea area;
    private int monsterNumber;
    private int lives;

    public Game(){
        Random rd=new Random();
        monsterNumber=rd.nextInt(3)+3;
        lives=3;
        area=new GameArea();
        player=new Player(area);
        monsters=new GameObject[getMonsterNumber()];
        for (int m=0; m<getMonsterNumber();m++) {
            if(m%2==0)
                monsters[m]=new DumbMonster(area);
            else
                monsters[m]=new SmartMonster(area);
        }


    }

    public int getMonsterNumber() {
        return monsterNumber;
    }

    public int getLives() {
        return lives;
    }


    public boolean moveMonsters(GameObject player){
        boolean loop=true;
        for(int m=0;m<monsters.length;m++){
            loop=loop && monsters[m].move(player);

            for (int n=0;n<monsters.length;n++)
                if(n!=m){
                    if(monsters[m].getX()==monsters[n].getX() && monsters[m].getY()==monsters[n].getY())
                        monsters[m].moveRight();
                }
        }
        return loop;
    }

    public int playGame(GameWindow window,  Game game, InputProcessor input) throws InterruptedException {
        boolean loop=true, move;
        int steps=0;
        window.draw( game);

        while(loop) {
            move=player.movePlayer(input, window);
            steps++;
            if(move)
                loop=moveMonsters(player);
            window.draw( game);
        }
        return steps;
    }

    public void resetGame(){
        player=new Player(area);
        for (int m=0; m<getMonsterNumber();m++) {
            if(m%2==0)
                monsters[m]=new DumbMonster(area);
            else
                monsters[m]=new SmartMonster(area);
        }

    }
    public void gameLoop(Game game, GameWindow window, InputProcessor input) throws InterruptedException{
        int steps, moves=0;
        for (int i = game.getLives()-1; i>=0; i--){

            steps=playGame(window, game, input);

            if(moves<steps)
                moves=steps;

            window.printMessage( area, "Score: "+steps+". You have "+i+" lives left.");
            input.startKey( window);

            if(i>0)
                resetGame();
            else {

                window.printMessage( area,"Game over! Your highest score: " + moves + ".    ");
                input.startKey( window);
            }

        }
    }
}


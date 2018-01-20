
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class GameWindow {

    Terminal terminal = TerminalFacade.createTerminal(System.in,
            System.out, Charset.forName("UTF8"));

    public GameWindow(){
       terminal.enterPrivateMode();
    }

    public void draw(Game game){

        int borderLeft=game.area.getStartX();
        int borderRight=borderLeft+ game.area.getWidth();
        int borderUp=game.area.getStartY();
        int borderDown=borderUp+game.area.getHeight();

        terminal.clearScreen();

        terminal.applyBackgroundColor(Terminal.Color.GREEN);   //draw borders
        for( int i=borderLeft; i<borderRight; i++){
            terminal.moveCursor(i, borderUp);
            terminal.putCharacter('-');
        }
        for( int i=borderLeft; i<borderRight; i++){
            terminal.moveCursor(i, borderDown-1);
            terminal.putCharacter('-');
        }
        for( int i=borderUp; i<borderDown; i++){
            terminal.moveCursor(borderLeft, i);
            terminal.putCharacter('|');
        }
        for( int i=borderUp; i<borderDown; i++){
            terminal.moveCursor(borderRight, i);
            terminal.putCharacter('|');
        }

        terminal.applyBackgroundColor(Terminal.Color.YELLOW);         // draw player
        terminal.applyForegroundColor(Terminal.Color.BLACK);
        terminal.moveCursor(game.player.getX(), game.player.getY());
        terminal.putCharacter('\u263A');

        terminal.applyBackgroundColor(Terminal.Color.BLUE);        // draw monsters
        terminal.applyForegroundColor(Terminal.Color.BLACK);
        for (GameObject monster:game.monsters) {
            terminal.moveCursor(monster.getX(), monster.getY());
            terminal.putCharacter('\u26C7');
        }

        terminal.moveCursor(0,0);

    }

    public void printMessage(GameArea area, String message){

        terminal.moveCursor(area.getStartX(),1);
        for (int i=0;i<message.length();i++)
        {
            terminal.moveCursor(area.getStartX()+i,1);
            terminal.putCharacter(message.charAt(i));

        }
        terminal.moveCursor(0,0);
    }

    public void closeWindow(){
        terminal.exitPrivateMode();
        System.exit(0);
    }
}

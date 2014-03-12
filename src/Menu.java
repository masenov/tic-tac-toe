import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
 
public class Menu extends BasicGameState{
 
    public static final int ID = 1;
    private StateBasedGame game;

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {

    	this.game = game;
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
    	g.setColor(Color.white);
        g.drawString("Tic Tac Toe", 100, 10);
     
        g.drawString("1. Play", 50, 100);
        g.drawString("2. Quit", 50, 140);
 
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        // TODO Auto-generated method stub
 
    }
    public void keyReleased(int key, char c) {
    	if (key == Input.KEY_1) {
    		game.enterState(Play.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    
    	}
    }
    	
 
    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return ID;
    }
 
}
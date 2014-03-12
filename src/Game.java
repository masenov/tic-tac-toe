import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
 
public class Game extends StateBasedGame{
 
	public static final String gamename = "Tic Tac Toe";
	

    public static void main(String[] args) {
    	AppGameContainer appgc;
    	   try{
    	      appgc = new AppGameContainer(new Game(gamename));
    	      appgc.setDisplayMode(300, 300, false);
    	      appgc.start();
    	   }catch(SlickException e){
    	      e.printStackTrace();
    	   }
    }
 
    public Game(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }
 
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
    	addState(new Menu()); 
    	addState(new Play());
    }
 
}
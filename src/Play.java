import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
 
public class Play extends BasicGameState{
 
    public static final int ID = 2;
    private StateBasedGame game;
    Image background = null;
    Image X = null;
    Image O = null;
    private int posx;
    private int posy;
    private boolean turn;
    private int[][] pos = new int[3][3];
    private int count = 0;
    private int win=0;
	
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
    	this.game = game;
    	background = new Image("data/bgr.png");
    	X = new Image("data/X.jpg");
    	O = new Image("data/O.jpg");
    	this.turn = true;
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			pos[i][j]=0;
    		}
    	}
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
    	background.draw(0,0);
    	for(int i =0;i<3;i++){
    		for(int j=0;j<3;j++){
    			if(pos[i][j]==1){
    				X.draw(100*i,100*j);
    			}
    			else if(pos[i][j]==5){
    				O.draw(100*i,100*j);
    			}
    		}
    	}
 
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
    	if(win()){
    		game.enterState(Menu.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    	}
    	if(!turn){
    		this.eval();

    		pos[posx][posy] = 5;
    		this.count++;
    		turn = true;
    	}
 
    }
    
    public void mousePressed(int button, int x, int y) {
    	if(turn) {
	    	if(pos[x/100][y/100]==0){
	    		pos[x/100][y/100] = 1;
	    	}
	    	turn = false;
    	}
    }
    
    public boolean win(){
    	for(int i = 0;i<3;i++){
    		for(int j=0;j<3;j++){
    			int column = pos[i][j]+pos[(i+1)%3][j]+pos[(i+2)%3][j];
    			int rows = pos[i][j]+pos[i][(j+1)%3]+pos[i][(j+2)%3];
    			
    			if(column==3 || rows==3) {
    				win=1;
    				return true;
    			}
    			else if(column==15 || column==15){
    				win=2;
    				return true;
    			}
    			
    			if(i==j) {
    				int diagonal = pos[i][j]+pos[(i+1)%3][(j+1)%3]+pos[(i+2)%3][(j+2)%3];
    				if(diagonal==3) {
    					win=1;
    					return true;
    				}
    				else if(diagonal==15){
    					win=2;
    					return true;
    				}
    			}
    			
    			if(i+j==2){
    				int diagonal = pos[i][j]+pos[(i+1)%3][(j+2)%3]+pos[(i+2)%3][(j+1)%3];
    				if(diagonal==3){
    					win = 1;
    					return true;
    				}
    				else if(diagonal==15){
    					win = 2;
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public void eval() {
    	int score = 0;
    	int high = 0;
    	int xs = 0;
    	int ys = 0;
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			if(pos[i][j]==0){
    				if(i==1 && j==1) score+=2;
    				else if(Math.abs(i-j)!=1) score+=1;
    	    		System.out.println("sds");

    				int columns = pos[i][j]+pos[(i+1)%3][j]+pos[(i+2)%3][j];
    				if(columns==1) score+=10;
    				else if(columns==2) score+=50;
    				else if(columns==5) score+=5;
    				else if(columns==10) score+=20;
    				
    				int rows = pos[i][j]+pos[i][(j+1)%3]+pos[i][(j+2)%3];
    				if(rows==1) score+=10;
    				else if(rows==2) score+=50;
    				else if(rows==5) score+=5;
    				else if(rows==10) score+=20;
    				
    				if(i==j){
    					int diagonal = pos[i][j]+pos[(i+1)%3][(j+1)%3]+pos[(i+2)%3][(j+2)%3];
    					if(diagonal==1) score+=10;
        				else if(diagonal==2) score+=50;
        				else if(diagonal==5) score+=5;
        				else if(diagonal==10) score+=20;
    				}
    				
    				if(i+j==2){
    					int diagonal = pos[i][j]+pos[(i+1)%3][(j+2)%3]+pos[(i+2)%3][(j+1)%3];
    					if(diagonal==1) score+=10;
        				else if(diagonal==2) score+=50;
        				else if(diagonal==5) score+=5;
        				else if(diagonal==10) score+=20;
    				}	
    			}
    			if(score>high) {
    				high=score;
    				xs=i;
    				ys=j;
    			}
    			score = 0;
    		}
    	}
    	this.posx = xs;
    	this.posy = ys;

    }
 
    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return ID;
    }
 
}
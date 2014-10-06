package catfindfishbone;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


import catfindfishbone.Fishbone;
import catfindfishbone.Cat;
import catfindfishbone.MainGame;

public class MainGame extends BasicGame {
	
	  public static final int GAME_WIDTH = 640;
	  public static final int GAME_HEIGHT = 640;
	  private Fishbone fishbone;
	  private Cat cat;
	  private BackgroundMaingame bgmain;
	  private int score;
	  private int time;
	  private boolean isGameOver = false;
	  private boolean isStarted = false;

	public MainGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		bgmain.draw();
		cat.draw();
	//	fishbone.draw();
		g.setColor(Color.red);	    
		g.drawString("Score : " + score, 510, 45);
		g.drawString("Time : " + (60+(time/1000)), 100, 45);

		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		cat = new Cat(150, 100);
		fishbone = new Fishbone(100, 100);
		bgmain = new BackgroundMaingame(0,0);
	}

	void updateCatMovement(Input input, int delta) {
	      if (input.isKeyDown(Input.KEY_LEFT)) {
	    	  isStarted = true;
	    	  cat.moveLeft(fishbone.getCenterX());
	      }
	      if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	  isStarted = true;
	    	  cat.moveRight(fishbone.getCenterX());
	      }
	      if (input.isKeyDown(Input.KEY_DOWN)) {
	    	  isStarted = true;
	    	  cat.moveDown(fishbone.getCenterY());
		  }
		  if (input.isKeyDown(Input.KEY_UP)) {
			  isStarted = true;
			  cat.moveUp(fishbone.getCenterY());
		  }
		  if (input.isKeyDown(Input.KEY_SPACE)){
			  isStarted = true;
			  handleCollision();
		  }
	    }
	
	private void handleCollision() {
	    if (cat.closeTo(fishbone.getCenterX(), fishbone.getCenterY())) {
	    	fishbone.setPosition();
	    	score += 10;
	    	time += 5000;
	    }
	    else{
	    	time -= 20; 	
	    }
	    
	  }   
	
	    @Override
	    public void update(GameContainer container, int delta) throws SlickException {
	      if(isGameOver == false){
	    	  Input input = container.getInput();
	    	  updateCatMovement(input, delta);
	//    	  handleCollision();
	    	  if(isStarted == true){
	    		  time -= delta;
	    		  if(60+(time/1000) <= 0){
	    			  isGameOver = true;
	    		  }
	    	  }
	      }
	    }
		
	
	
	public static void main(String[] args) {
	    try {
	      MainGame game = new MainGame("Cat Find Fishbone");
	      AppGameContainer container = new AppGameContainer(game);
	      container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	//    container.setMinimumLogicUpdateInterval(800 / 60);
	      container.setShowFPS(false);
		  container.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
	

}

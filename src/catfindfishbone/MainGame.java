package catfindfishbone;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import catfindfishbone.Fishbone;
import catfindfishbone.Cat;
import catfindfishbone.MainGame;

public class MainGame extends BasicGame {

	  private Fishbone fishbone;
	  private Cat cat;
	  private BackgroundMaingame bgmain;
	  private int score;
	private int time;
	private boolean isGameOver = false;

	public MainGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		bgmain.draw();
		cat.draw();
		fishbone.draw();
//		bgmain.draw();
		g.drawString("" + score, 600, 0);
		g.drawString("Time : " + (60+(time/1000)), 100, 0);

		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
	//    Color background = new Color(0,205,0);
	 //   container.getGraphics().setBackground(background); 
		cat = new Cat(100, 100);
		fishbone = new Fishbone(200, 200);
		bgmain = new BackgroundMaingame(-100,-100);
	}

	void updateShipMovement(Input input, int delta) {
	      if (input.isKeyDown(Input.KEY_LEFT)) {
	    	  cat.moveLeft(fishbone.getCenterX());
	      }
	      if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	  cat.moveRight(fishbone.getCenterX());
	      }
	      if (input.isKeyDown(Input.KEY_DOWN)) {
	    	  cat.moveDown(fishbone.getCenterY());
		  }
		  if (input.isKeyDown(Input.KEY_UP)) {
			  cat.moveUp(fishbone.getCenterY());
		      }
	    }
	
	private void handleCollision() {
	    if (cat.closeTo(fishbone.getCenterX(), fishbone.getCenterY())) {
	    	fishbone.setPosition();
	      score += 10;
	    }
	  }   
	
	    @Override
	    public void update(GameContainer container, int delta) throws SlickException {
	      if(isGameOver == false){
	    	  Input input = container.getInput();
	    	  updateShipMovement(input, delta);
	    	  handleCollision();
	    	  time -= delta;
	    	  if(60+(time/1000) <= 0){
	    		  isGameOver = true;
	      }
	      }
	    }
		
	
	
	public static void main(String[] args) {
	    try {
	      MainGame game = new MainGame("Super Ship Game");
	      AppGameContainer container = new AppGameContainer(game);
	      container.setDisplayMode(640, 480, false);
	//      container.setMinimumLogicUpdateInterval(800 / 60);
	      container.setShowFPS(false);
		  container.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
	

}

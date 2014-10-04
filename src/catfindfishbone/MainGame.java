package catfindfishbone;


import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.UnicodeFont;

import catfindfishbone.Fishbone;
import catfindfishbone.Cat;
import catfindfishbone.MainGame;

public class MainGame extends BasicGame {
	
	  Font font;
	  private Fishbone fishbone;
	  private Cat cat;
	  private BackgroundMaingame bgmain;
	  private int score;
	  private int time;
	  private boolean isGameOver = false;
	  private SpriteSheet monster;
	  private Animation monsterAnimation;

	public MainGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		bgmain.draw();
//		cat.draw();
		fishbone.draw();
		cat.draw();
//		monsterAnimation.draw();    
		g.setColor(Color.red);	    
		g.drawString("Score : " + score, 510, 45);
		g.drawString("Time : " + (60+(time/1000)), 100, 45);

		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		cat = new Cat(100, 100);
		fishbone = new Fishbone(200, 200);
		monster = new SpriteSheet("C:/Users/Lenovo/Desktop/sprite.png",95,100);
		monsterAnimation = new Animation(monster,95);
		bgmain = new BackgroundMaingame(0,0);
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
		  if (input.isKeyDown(Input.KEY_SPACE)){
			  handleCollision();
		  }
	    }
	
	private void handleCollision() {
	    if (cat.closeTo(fishbone.getCenterX(), fishbone.getCenterY())) {
	    	fishbone.setPosition();
	    	score += 10;
	    	time += 10000;
	    }
	    else{
	//    	time -= 20; 	
	    }
	    
	  }   
	
	    @Override
	    public void update(GameContainer container, int delta) throws SlickException {
	      if(isGameOver == false){
	    	  Input input = container.getInput();
	    	  updateShipMovement(input, delta);
	//    	  handleCollision();
	    	  time -= delta;
	    	  if(60+(time/1000) <= 0){
	    		  isGameOver = true;
	      }
	      }
	    }
		
	
	
	public static void main(String[] args) {
	    try {
	      MainGame game = new MainGame("Cat Find Fishbone");
	      AppGameContainer container = new AppGameContainer(game);
	//      container.setDisplayMode(640, 480, false);
	      container.setDisplayMode(640, 640, false);
	//      container.setMinimumLogicUpdateInterval(800 / 60);
	      container.setShowFPS(false);
		  container.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
	

}

package catfindfishbone;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import catfindfishbone.Fishbone;
import catfindfishbone.Cat;
import catfindfishbone.MainGame;

public class MainGame extends BasicGame {

	  private Fishbone fishbone;
	  private Cat cat;
	  private int score;

	public MainGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		cat.draw();
		fishbone.draw();
		g.drawString("" + score, 600, 0);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		cat = new Cat(100, 100);
		fishbone = new Fishbone(200, 200);
	}

	void updateShipMovement(Input input, int delta) {
	      if (input.isKeyDown(Input.KEY_LEFT)) {
	    	  cat.moveLeft();
	      }
	      if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	  cat.moveRight();
	      }
	      if (input.isKeyDown(Input.KEY_DOWN)) {
	    	  cat.moveDown();
		  }
		  if (input.isKeyDown(Input.KEY_UP)) {
			  cat.moveUp();
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
	      Input input = container.getInput();
	      updateShipMovement(input, delta);
	      handleCollision();
	    }
		
	
	
	public static void main(String[] args) {
	    try {
	      MainGame game = new MainGame("Super Ship Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(640, 480, false);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
	

}

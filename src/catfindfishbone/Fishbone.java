package catfindfishbone;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fishbone {
	
	  public static final int WIDTH = 40;
	  public static final int HEIGHT = 40;
	  private Image image;
	  public int x;
	  public int y;
	  Random ran = new Random();
	  
	  public Fishbone(int x, int y) throws SlickException {
		setPosition();
	    image = new Image("res/fishbone.png");
	  }
	 
	  
	  public void draw() {
	    image.draw(x, y);
	  }

	  public int getCenterX() {
		    return x;
		  }
		  public int getCenterY() {
		    return y;
		  }
		  public void setPosition() {
			  this.x = ran.nextInt(MainGame.GAME_WIDTH-Cat.WIDTH);
			  this.y = ran.nextInt(MainGame.GAME_HEIGHT-Cat.HEIGHT);


		  }


}

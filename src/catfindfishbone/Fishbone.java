package catfindfishbone;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fishbone {
	
	  private Image image;
	  public int x;
	  public int y;
	  Random ran = new Random();
	  public Fishbone(int x, int y) throws SlickException {
		setPosition();
	    image = new Image("C:/Users/Lenovo/Desktop/gold.png");
	  }
	 
	  
	  public void draw() {
	    image.draw(x, y);
	  }

	  public int getCenterX() {
		    return x+5;
		  }
		  public int getCenterY() {
		    return y+4;
		  }
		  public void setPosition() {
			  this.x = ran.nextInt(580);
			  this.y = ran.nextInt(580);
		      System.out.print(x+" ");
		      System.out.println(y);

		  }


}

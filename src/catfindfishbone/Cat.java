package catfindfishbone;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cat {
	  private Image image;
	  private int x;
	  private int y;
	 
	  public Cat(int x, int y) throws SlickException {
	    image = new Image("C:/Users/Lenovo/Desktop/ship.png");
	    this.x = x;
	    this.y = y;
	  }

	public void draw() {
		image.draw(x,y);	
		
	}
	
	public void moveLeft() {
		if((x>=0))
			x-=1;
		
	}
	public void moveRight() {
		if((x<=580))
			x+=1;
		
	}

	public void moveDown() {
		if((y<=410))
			y+=1;
		
	}

	public void moveUp() {
		if((y>=0))
			y-=1;
		
	}

	public boolean closeTo(int fishbonex, int fishboney) {
		if ((fishbonex >= this.x) && (fishbonex <= this.x+64) && (fishboney >= this.y) && (fishboney <= this.y+64)) return true;
		else return false;
	}

}

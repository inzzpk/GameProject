package catfindfishbone;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cat {
	  private Image image;
	  private int x;
	  private int y;
	  private int colorsr =500;
	  private int colorsb =500;
	  private Fishbone fishbone;
	 
	  public Cat(int x, int y) throws SlickException {
	    image = new Image("C:/Users/Lenovo/Desktop/ship.png");
	    this.x = x;
	    this.y = y;
	  }

	public void draw() {
		Color color = new Color(colorsr,0,100,colorsb);
	//	Color color = new Color(256,0,0,255);
		image.draw(x,y,color);	
		
	}
	
	
	public void moveLeft(int fishbonex) {
		if((x>=0)){
			colorsr = 450;
			x-=1;
			colorsr = colorsr - (Math.abs(x-fishbonex));
			
		}
		
	}
	public void moveRight(int fishbonex) {
		if((x<=580)){
			colorsr = 450;
			x+=1;
			colorsr = colorsr - (Math.abs(x-fishbonex));
		}
	}

	public void moveDown(int fishboney) {
		if((y<=410)){
			colorsb = 375;
			y+=1;
		    colorsb = colorsb - ((Math.abs(y-fishboney))*(5/3));
		 }
		
	}

	public void moveUp(int fishboney) {
		if((y>=0)){
			colorsb = 375;
			y-=1;
			colorsb = colorsb - ((Math.abs(y-fishboney))*(5/3));
		}
	}

	public boolean closeTo(int fishbonex, int fishboney) {
		if ((fishbonex >= this.x) && (fishbonex <= this.x+64) && (fishboney >= this.y) && (fishboney <= this.y+64)) return true;
		else return false;
	}
	


}

package catfindfishbone;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cat {
	  private Image image;
	  private int x;
	  private int y;
	  private int colorsx ;
	  private int colorsy ;
	  private Fishbone fishbone;
	 
	  public Cat(int x, int y) throws SlickException {
	    image = new Image("C:/Users/Lenovo/Desktop/ship.png");
	//    image = new Image("rsc/ship.png");
	    this.x = x;
	    this.y = y;
	  }

	public void draw() {
		Color color = new Color(0,0,0);
		color = new Color((colorsx+colorsy),0,0);
		image.draw(x,y,color);	
		System.out.println(colorsx+colorsy);
		
	}
	
	
	
	
	public void moveLeft(int fishbonex) {
		if((x>=0)){
			colorsx = 255;
			x-=1;
			colorsx = colorsx - (Math.abs(x-fishbonex));
			
		}
		
	}
	public void moveRight(int fishbonex) {
		if((x<=580)){
			colorsx = 255;
			x+=1;
			colorsx = colorsx - (Math.abs(x-fishbonex));
		}
	}

	public void moveDown(int fishboney) {
		if((y<=580)){
			colorsy = 255;
			y+=1;
		    colorsy = colorsy - (Math.abs(y-fishboney));
		 }
		
	}

	public void moveUp(int fishboney) {
		if((y>=0)){
			colorsy = 255;
			y-=1;
			colorsy = colorsy - (Math.abs(y-fishboney));
		}
	}

	public boolean closeTo(int fishbonex, int fishboney) {
		if ((fishbonex >= this.x-50) && (fishbonex <= this.x+50) && (fishboney >= this.y-50) && (fishboney <= this.y+50)) {
			return true;}
		else return false;
	}
	


}

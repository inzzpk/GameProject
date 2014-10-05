package catfindfishbone;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackgroundMaingame {
	
		private int x;
		private int y;
		private Image image;

		public BackgroundMaingame(int x, int y) throws SlickException {
			image = new Image("res/bgmainnnn.png");
			this.x = x;
			this.y = y;
		}
		
		public void  draw() {
			image.draw(x, y);
			
		}
        
		

}

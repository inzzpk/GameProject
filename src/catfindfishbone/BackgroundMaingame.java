package catfindfishbone;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class BackgroundMaingame {
	
		private int x;
		private int y;
		private Image image;
		private Music music;

		public BackgroundMaingame(int x, int y) throws SlickException {
			image = new Image("res/bgmainnnn.png");
			this.x = x;
			this.y = y;
			music = new Music("res/BGSound.wav");
			music.setVolume(0.1f);
		}
		
		public void  draw() {
			image.draw(x, y);
			
		}
		
		public void  play() {
			music.loop();
			
		}
        
		

}

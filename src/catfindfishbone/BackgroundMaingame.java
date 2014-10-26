package catfindfishbone;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;


public class BackgroundMaingame {
	
		private int x;
		private int y;
		private Image image;
		private Image imagetime;
		private Music music;
		private TrueTypeFont font1,font2;
		

		public BackgroundMaingame(int x, int y) throws SlickException {
			image = new Image("res/bgmainnnn.png");
			imagetime = new Image("res/bgmainnnntime.png");
			this.x = x;
			this.y = y;
			music = new Music("res/BGSound.wav");
			music.setVolume(0.1f);
			try {
				InputStream inputStream1 = ResourceLoader.getResourceAsStream("AGENCYB.TTF");
				InputStream inputStream2 = ResourceLoader.getResourceAsStream("AGENCYB.TTF");
				 
				Font s1 = Font.createFont(Font.TRUETYPE_FONT, inputStream1);
				s1 = s1.deriveFont(40f); // set font size
				Font s2 = Font.createFont(Font.TRUETYPE_FONT, inputStream2);
				s2 = s2.deriveFont(50f); // set font size
				
				font1 = new TrueTypeFont(s1, false);
				font2 = new TrueTypeFont(s2, false);
				 
				} catch (Exception e) {
				e.printStackTrace();
				}   
			
		}
		
		public void  draw() {
			image.draw(x, y);
			
		}
		
		public void  drawtime() {
			imagetime.draw(x, y);
			
		}
		
		public void  play() {
			music.loop();
			
		}
		public void gameover(){
			font2.drawString(220, 230, "Game Over", Color.red);
		}
		
		public void timeandscore(int time , int score){
			font1.drawString(510, 30, "" + score);
			font1.drawString(100, 30, "" + (60 + (time / 1000)));
		}
		
		public void timeandscore_time(int time , int score){
			font1.drawString(510, 30, "" + score);
			font1.drawString(100, 30, "" + (time / 1000));
		}

}

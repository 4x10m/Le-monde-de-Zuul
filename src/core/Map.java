package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Map implements Component {
	Color[][] squares = null;
	public static int w = 0, h = 0, squarew = 0, squareh = 0;
	
	public Map(GameContainer container, int w, int h) {
		this.w = w;
		this.h = h;
		
		squares = new Color[w][h];
		
		squarew = container.getWidth() / w;
		squareh = container.getHeight() / h;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(i == 0 || j == 0 || i == w - 1 || j == h - 1) {
					squares[i][j] = Color.black;
				}
				else {
					squares[i][j] = Color.gray;
				}
			}
		}
	}

	@Override
	public void update(int dt) {
	}

	@Override
	public void draw(Graphics arg0) {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				arg0.setColor(squares[i][j]);
				arg0.fillRect(i * squarew, j * squareh, squarew, squareh);
			}
		}
	}
}

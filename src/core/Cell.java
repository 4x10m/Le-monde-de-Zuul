package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Cell {
	private static final Color backgroundcolor = Color.gray, bordercolor = Color.black;
	
	private final int x, y;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Color getBackgroundColor() {
		return backgroundcolor;
	}
	
	public Color getBorderColor() {
		return bordercolor;
	}
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics arg0, int w, int h) {
		int drawedx = 0, drawedy = 0;
		
		drawedx = getX() * w;
		drawedy = getY() * h;
		
		arg0.setColor(getBackgroundColor());
		arg0.fillRect(drawedx, drawedy, w, h);
		
		arg0.setColor(getBorderColor());
		arg0.drawRect(drawedx, drawedy, w, h);
	}
}
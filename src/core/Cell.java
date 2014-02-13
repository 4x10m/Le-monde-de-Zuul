package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Cell {
	private Boolean walkable = true;
	private Color color = null, bordercolor = Color.black;
	private int x = 0, y = 0, w = 0, h = 0;
	
	public Boolean isWalkable() {
		return walkable;
	}
	
	public void setWalkable(Boolean walkable) {
		if(walkable != null) {
			this.walkable = walkable;
		}
	}
	
	public Cell(Color color, int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.color = color;
	}
	
	
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void resize(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public void draw(Graphics arg0) {
		arg0.setColor(color);
		arg0.fillRect(x, y, w, h);
		
		arg0.setColor(bordercolor);
		arg0.drawRect(x, y, w, h);
	}
}
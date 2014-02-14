package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import enums.CellTypes;

public class Cell {
	private static final Color walkablecolor = Color.gray, unwalkablecolor = Color.black, teleportercolor = Color.red;
	private CellTypes type;
	private Color color = null, bordercolor = Color.black;
	private int x = 0, y = 0, w = 0, h = 0;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getW() {
		return w;
	}
	
	public int getH() {
		return h;
	}
	
	public CellTypes getType() {
		return type;
	}
	
	public Cell(CellTypes type, int x, int y, int w, int h) throws NotImplementedCellTypeException {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.color = color;
		
		this.type = type;
		
		switch(type){
		case Teleporter:
			color = teleportercolor;
			break;
		case UnWalkable:
			color = unwalkablecolor;
			break;
		case Walkable:
			color = walkablecolor;
			break;
		default:
			throw new NotImplementedCellTypeException();
		
		}
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
		arg0.fillRect(getX() * getW(), getY() * getH(), w, h);
		
		arg0.setColor(bordercolor);
		arg0.drawRect(getX() * getW(), getY() * getH(), w, h);
		arg0.setColor(Color.darkGray);
		arg0.fillOval(getX() * getW(), getY() * getH(), getW(), getH());
		
	}
	
	public class NotImplementedCellTypeException extends Exception {
		public NotImplementedCellTypeException() {
			super("Trying to initialize a type of cell not implemented yet");
		}
	}
}
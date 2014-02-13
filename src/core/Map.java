package core;

import java.io.File;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.jdom2.Element;

public class Map {
	Cell[][] cells = null;
	public static int w = 0, h = 0, squarew = 0, squareh = 0;
	
	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
	
	public Map(GameContainer container, int w, int h) {
		this.w = w;
		this.h = h;
		
		cells = new Cell[w][h];
		
		squarew = container.getWidth() / w;
		squareh = container.getHeight() / h;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(i == 0 || j == 0 || i == w - 1 || j == h - 1) {
					cells[i][j] = new Cell(Color.black, i * squarew, j * squareh, squarew, squareh);
					cells[i][j].setWalkable(false);
				}
				else {
					cells[i][j] = new Cell(Color.gray, i * squarew, j * squareh, squarew, squareh);
				}
			}
		}
	}

	public void update(int dt) {
	}
	
	public void draw(Graphics arg0) {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				cells[i][j].draw(arg0);
			}
		}
	}
	
	public static Map[] loadMaps() {
		File xmlmapsfile
		Map[] mapstable = null;
		Map tempmap = null;
		int x = 0, y = 0, w = 0, h = 0;
		
		mapstable = new Map[mapsnodes.length];
		
		for(Element map : mapsnodes) {
			x = Integer.parseInt(map.getAttributeValue("x", "0"));
			y = Integer.parseInt(map.getAttributeValue("y", "0"));
			w = Integer.parseInt(map.getAttributeValue("w", "0"));
			h = Integer.parseInt(map.getAttributeValue("h", "0"));
		}
		
		return null;
	}
}

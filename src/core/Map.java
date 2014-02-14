package core;

import java.io.File;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLParser;

import core.Cell.NotImplementedCellTypeException;
import enums.CellTypes;

public class Map {
	Cell[][] cells = null;
	private final int x, y, w, h, squarew, squareh;
	private final GameContainer container;
	
	public int getW() {
		return w;
	}
	
	public int getH() {
		return h;
	}
	
	public int getSquareW() {
		return squarew;
	}
	
	public int getSquareH() {
		return squareh;
	}
	
	private void setCell(int x, int y, Cell cell) {
		assert(x < w && y < h);
		assert(cell != null);
		
		cells[x][y] = cell;
	}
	
	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
	
	public Map(GameContainer container, int x, int y, int w, int h) throws NotImplementedCellTypeException {
		this.container = container;
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		cells = new Cell[w][h];
		
		squarew = container.getWidth() / w;
		squareh = container.getHeight() / h;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(i == 0 || j == 0 || i == w - 1 || j == h - 1) {
					cells[i][j] = new Cell(CellTypes.UnWalkable, i, j, squarew, squareh);
				}
				else {
					cells[i][j] = new Cell(CellTypes.Walkable, i, j, squarew, squareh);
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
	
	public static Map loadMap(GameContainer container, int x, int y) throws SlickException, NotImplementedCellTypeException {
		Map value = null;
		XMLParser parser = new XMLParser();
		String xmlmapsfilepath = "res/xml/maps.xml";
		
		XMLElement root = parser.parse(xmlmapsfilepath);
	
		for(int i = 0; i < root.getChildren().size(); i++) {
			if(root.getChildren().get(i).getName() == "map") {
				int loadedx = 0, loadedy = 0, loadedw = 0, loadedh = 0;
				
				loadedx = Integer.parseInt(root.getChildren().get(i).getAttribute("x"));
				loadedy = Integer.parseInt(root.getChildren().get(i).getAttribute("y"));
				loadedw = Integer.parseInt(root.getChildren().get(i).getAttribute("w"));
				loadedh = Integer.parseInt(root.getChildren().get(i).getAttribute("h"));
				
				if(loadedx == x && loadedy == y) {
					value = new Map(container, loadedx, loadedy, loadedw, loadedh);
				}
			}
		}
		
		return value;
	}
}

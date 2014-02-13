package core;

import java.io.File;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLParser;

import core.Cell.NotImplementedCellTypeException;
import enums.CellTypes;

public class Map {
	Cell[][] cells = null;
	private int w = 0, h = 0, squarew = 0, squareh = 0;
	
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
	
	public Map(GameContainer container, int w, int h) throws NotImplementedCellTypeException {
		this.w = w;
		this.h = h;
		
		cells = new Cell[w][h];
		
		squarew = container.getWidth() / w;
		squareh = container.getHeight() / h;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(i == w - 1 && j == 5) {
					setCell(i, j, new Cell(CellTypes.Teleporter, i, j, squarew, squareh));
				}
				else {
					if(i == 0 || j == 0 || i == w - 1 || j == h - 1) {
						cells[i][j] = new Cell(CellTypes.UnWalkable, i, j, squarew, squareh);
					}
					else {
						cells[i][j] = new Cell(CellTypes.Walkable, i, j, squarew, squareh);
					}
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
		/*Map[] mapstable = null;
		XMLParser parser = new XMLParser();
		String xmlmapsfilepath = "res/xml/maps.xml";
		File xmlmapsfile = new File(xmlmapsfilepath);
		
		if(!xmlmapsfile.exists()) throw new Exception("Unable to load the game, some documents are missing");
		
		XMLElement root = parser.parse(xmlmapsfilepath);
		
		mapstable = new Map[root.getChildren().size();
	
		for(int i = 0; i < root.getChildren().size(); i++) {
			Map tempmap = null;
			int x = 0, y = 0, w = 0, h = 0;
			
			for(Element map : mapsnodes) {
				x = Integer.parseInt(map.getAttributeValue("x", "0"));
				y = Integer.parseInt(map.getAttributeValue("y", "0"));
				w = Integer.parseInt(map.getAttributeValue("w", "0"));
				h = Integer.parseInt(map.getAttributeValue("h", "0"));
			}
		}*/
		
		return null;
	}
}

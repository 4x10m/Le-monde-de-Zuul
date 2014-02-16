package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLParser;

public class Map {
	private static final String mapsfilepath = "res/xml/maps.xml";
	
	private final Cell[] cells;
	private final int id, w, h, squarew, squareh;
	
	public int getID() {
		return id;
	}
	
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
	
	private void appendTeleporter(Cell teleporter) {
		for(int i = 0; i < cells.length; i++) {
			if(cells[i].getX() == teleporter.getX() && cells[i].getY() == teleporter.getY()) {
				cells[i] = teleporter;
			}
		}
	}
	
	public Cell getCell(int x, int y) {
		Cell value = null;
		
		for(Cell cell : cells) {
			if(cell.getX() == x && cell.getY() == y) {
				value = cell;
				
				break;
			}
		}
		
		return value;
	}
	
	private Map(Cell[] cells, int id, int w, int h, int squarew, int squareh) {
		this.cells = cells;
		
		this.id = id;
		this.w = w;
		this.h = h;
		this.squarew = squarew;
		this.squareh = squareh;
	}
	
	public void draw(Graphics arg0) {
		for(Cell cell : cells) {
			cell.draw(arg0, getSquareW(), getSquareH());
		}
	}
	
	public static int getNumberOfMap() throws SlickException {
		XMLElement rootnode = null, mapnode = null;
		int number = 0;
		
		rootnode = new XMLParser().parse(mapsfilepath);
	
		number = rootnode.getChildrenByName("map").size();
		
		return number;
	}
	
	public static Map unpackMap(int id, int containerw, int containerh) throws SlickException {
		Map value = null;
		Cell[] cells = null;
		XMLElement rootnode = null, mapnode = null;
		int loadedid = 0, w = 0, h = 0, squarew = 0, squareh = 0;
		
		rootnode = new XMLParser().parse(mapsfilepath);
	
		for(int i = 0; i < rootnode.getChildren().size(); i++) {
			mapnode = rootnode.getChildren().get(i);
			loadedid = Integer.parseInt(mapnode.getAttribute("id"));
			
			if(id == loadedid) {
				w = Integer.parseInt(mapnode.getAttribute("w"));
				h = Integer.parseInt(mapnode.getAttribute("h"));
				
				squarew = containerw / w;
				squareh = containerh / h;
				
				cells = createCells(w, h);
				
				value = new Map(cells, id, w, h, squarew, squareh);
				
				loadMapItems(mapnode, value);
				loadMapTeleporters(mapnode, value);
			}
		}
		
		return value;
	}
	
	private static Cell[] createCells(int w, int h) {
		Cell[] value = null;
		Cell cell = null;
		int lenght = 0, i = 0, j = 0, index = 0, x = 0, y = 0;
		
		lenght = w * h;
		
		value = new Cell[lenght];
		
		for(i = 0; i < lenght; i++) {
			y = i / h;
			x = i % w;
			
			cell = new CommonCell(x, y);
	
			value[i] = cell;
		}
		
		return value;
	}
	
	private static void loadMapItems(XMLElement mapnode, Map map) {
		int i = 0;
		Cell cell = null;
		Item item = null;
		
		for(i = 0; i < mapnode.getChildrenByName("item").size(); i++) {
			item = Item.loadItem(mapnode.getChildrenByName("item").get(i));
			
			cell = map.getCell(item.getX(), item.getY());
			
			((CommonCell) cell).setItem(item);
		}
	}
	
	private static void loadMapTeleporters(XMLElement mapnode, Map map) {
		int i = 0;
		Teleporter teleporter = null;
		
		for(i = 0; i < mapnode.getChildrenByName("teleporter").size(); i++) {
			teleporter = Teleporter.parseFromXML(mapnode.getChildrenByName("teleporter").get(i));
			
			map.appendTeleporter(teleporter);
		}
	}
}

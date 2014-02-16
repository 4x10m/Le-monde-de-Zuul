package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.util.xml.XMLElement;

public class Teleporter extends Cell {
	private final int x, y, relatedmapid, relatedmapx, relatedmapy;
	private final int level;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getRelatedMap() {
		return relatedmapid;
	}
	
	public int getRelatedMapX() {
		return relatedmapx;
	}
	
	public int getRelatedMapY() {
		return relatedmapy;
	}
	
	@Override
	public Color getBackgroundColor() {
		return Levels.getLevelColor(level);
	}
	
	private Teleporter(int level, int relatedmapid, int relatedmapx, int relatedmapy, int x, int y) {
		super(x, y);
		
		this.level = level;
		this.relatedmapid = relatedmapid;
		this.relatedmapx = relatedmapx;
		this.relatedmapy = relatedmapy;
		this.x = x;
		this.y = y;
	}

	public static Teleporter parseFromXML(XMLElement teleporter) {
		Teleporter value = null;
		
		int x = 0, y = 0, relatedmapid = 0, relatedmapx = 0, relatedmapy = 0, level = 0;
		
		x = Integer.parseInt(teleporter.getAttribute("x"));
		y = Integer.parseInt(teleporter.getAttribute("y"));
		relatedmapid = Integer.parseInt(teleporter.getAttribute("relatedmapid"));
		relatedmapx = Integer.parseInt(teleporter.getAttribute("relatedmapx"));
		relatedmapy = Integer.parseInt(teleporter.getAttribute("relatedmapy"));
		
		level = Integer.parseInt(teleporter.getAttribute("level"));
		
		value = new Teleporter(level, relatedmapid, relatedmapx, relatedmapy, x, y);
		
		return value;
	}
}

package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLParser;

public class Levels {
	private static final String levelfilepath = "res/xml/levels.xml";
	
	private static Color[] levels = null;
	
	public static int getNumberOfLevel() {
		return levels.length;
	}
	
	public static Color getLevelColor(int level) {
		return levels[level];
	}
	
	public static void loadLevels() {
		try {
			XMLElement rootnode = new XMLParser().parse(levelfilepath);
			
			levels = new Color[rootnode.getChildren().size()];
			
			for(int i = 0; i < rootnode.getChildrenByName("level").size(); i++) {
				levels[i] = Color.decode(rootnode.getChildrenByName("level").get(i).getAttribute("color"));
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}

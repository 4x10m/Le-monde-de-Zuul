package core;

import org.newdawn.slick.SlickException;

public class MapManager {
	private static Map[] maps = null;
	
	public static Map getMap(int i) {
		return maps[i - 1];
	}
	
	public static void loadmaps(int containerw, int containerh) throws SlickException {
		maps = new Map[Map.getNumberOfMap()];
		
		for(int i = 0; i < maps.length; i++) {
			maps[i] = Map.unpackMap(i + 1, containerw, containerh);
		}
	}
}

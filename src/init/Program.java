package init;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.Menu;
import states.Play;

public class Program extends StateBasedGame {
	public static final String GAMENAME = "Le monde de Zuul";
	public static final int MENUSTATEID = 0, PLAYSTATEID = 1;
	public static final int MAPW = 16, MAPH = 16;
	
	public Program() {
		super(GAMENAME);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new Menu());
		addState(new Play());
	}

	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Program());
			container.setDisplayMode(800, 600, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}

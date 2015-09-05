package cs3750.blackjack.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import cs3750.blackjack.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BlackJack!";
		config.height = 772;
		config.width = 1286;
		new LwjglApplication(new MyGdxGame(), config);
	}
}

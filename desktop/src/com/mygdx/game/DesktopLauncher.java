package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.jga.util.ads.NullAdController;
import com.mygdx.game.config.GameConfig;


// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	
            public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(GameConfig.WIDTH,GameConfig.HEIGHT);
                

		config.setTitle("Definitely-not-Breakout");
		new Lwjgl3Application(new MyGdxGame(NullAdController.INSTANCE), config);
	}
}

package com.first.first;

import static com.first.first.First.SCR_HEIGHT;
import static com.first.first.First.SCR_WIDTH;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.first.first.First;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(SCR_WIDTH/2, SCR_HEIGHT/2);
		config.setForegroundFPS(60);
		config.setTitle("first");
		new Lwjgl3Application(new First(), config);
	}
}

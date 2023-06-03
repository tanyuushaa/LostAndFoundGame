package com.mygdx.game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("My Game");
        int width = 1200;
        int height = 1400;
        config.setWindowedMode(width, height);
        Menu Menu = new Menu();
        new Lwjgl3Application(Menu, config);
    }
}

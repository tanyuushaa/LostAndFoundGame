package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Menu extends ApplicationAdapter {
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private Window instructionWindow;
    private ShapeRenderer shapeRenderer;
    private Texture texture;

    @Override
    public void create() {
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        shapeRenderer = new ShapeRenderer();

        texture = new Texture(Gdx.files.internal("game.png"));

        skin = new Skin();
        Window mainMenu = new Window("Головне меню", skin);
        mainMenu.setSize(200, 300);
        mainMenu.setPosition(Gdx.graphics.getWidth() / 2f - mainMenu.getWidth() / 2f, Gdx.graphics.getHeight() / 2f - mainMenu.getHeight() / 2f);

        TextButton startButton = new TextButton("Почати гру", skin);
        TextButton continueButton = new TextButton("Продовжити гру", skin);
        TextButton settingsButton = new TextButton("Налаштування", skin);
        TextButton instructionButton = new TextButton("Інструкція", skin);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        continueButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        instructionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                instructionWindow = new Window("Інструкція", skin);
                instructionWindow.setSize(400, 300);
                instructionWindow.setPosition(Gdx.graphics.getWidth() / 2f - instructionWindow.getWidth() / 2f, Gdx.graphics.getHeight() / 2f - instructionWindow.getHeight() / 2f);
                Label instructionLabel = new Label("інструкція....", skin);
                instructionWindow.add(instructionLabel).expand().center();

                stage.addActor(instructionWindow);
            }
        });

        mainMenu.add(startButton).fillX().pad(5).row();
        mainMenu.add(continueButton).fillX().pad(5).row();
        mainMenu.add(settingsButton).fillX().pad(5).row();
        mainMenu.add(instructionButton).fillX().pad(5).row();

        stage.addActor(mainMenu);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        skin.dispose();
        shapeRenderer.dispose();
        texture.dispose();
    }
}

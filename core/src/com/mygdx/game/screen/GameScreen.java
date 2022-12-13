package com.mygdx.game.screen;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jga.util.game.GameBase;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.entity.EntityFactory;
import com.mygdx.game.game.GameController;
import com.mygdx.game.game.GameRenderer;
import com.mygdx.game.game.ScoreController;
import com.mygdx.game.game.SoundController;


public class GameScreen extends ScreenAdapter
{
    private final GameBase game;
    private final AssetManager assetManager;
    private final SpriteBatch batch;
    private final ScoreController scoreController;

    private GameController controller;
    private GameRenderer renderer;
    private EntityFactory factory;
    private SoundController soundController;



    public GameScreen(GameBase game) {
        this.game = game;
        assetManager = game.getAssetManager();
        batch = game.getBatch();
        scoreController = ((MyGdxGame)game).getScoreController();
        
    }

    public void show()
    {
        factory = new EntityFactory(assetManager);
        soundController = new SoundController(assetManager);
        controller = new GameController(soundController,scoreController,factory);
        renderer = new GameRenderer(controller,batch,assetManager);
    }

    public void render(float delta)
    {
        if (!controller.isGameOver()) {
            controller.paddleInputController.update(delta);
        }
        controller.update(delta);
        renderer.render(delta);
    }

    public void resize(int width,int height)
    {
        renderer.resize(width,height);
    }

    public void hide()
    {
        dispose();
    }

    public void dispose()
    {
        renderer.dispose();
    }

}

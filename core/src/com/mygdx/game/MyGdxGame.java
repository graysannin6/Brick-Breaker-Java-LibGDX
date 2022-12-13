package com.mygdx.game;


import com.jga.util.ads.AdController;
import com.jga.util.game.GameBase;
import com.mygdx.game.game.ScoreController;
import com.mygdx.game.screen.LoadingScreen;



public class MyGdxGame extends GameBase {

    private ScoreController scoreController;
    
    public MyGdxGame(AdController adController) {
        super(adController);
    }

    
    public void postCreate() {
        scoreController = new ScoreController();
        setScreen(new LoadingScreen(this));
    }

    public ScoreController getScoreController() {
        return scoreController;
    }
    
}

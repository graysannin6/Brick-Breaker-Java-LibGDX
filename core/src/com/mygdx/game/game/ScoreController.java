package com.mygdx.game.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.MyGdxGame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author chris
 */
public class ScoreController {

    private static final String HIGH_SCORE_KEY = "highDcore";
    
    private final Preferences prefs;
    
    private int score;
    private int highScore;
    
    
    
    public ScoreController() {
        this.prefs = Gdx.app.getPreferences(MyGdxGame.class.getSimpleName());
        highScore = prefs.getInteger(HIGH_SCORE_KEY, 0);
    
    }
    
    public void reset()
    {
        score = 0;
    }
    
    public void addScore(int toAdd)
    {
        score += toAdd;
    }
    public void updateHighScore()
    {
        if (score < highScore) 
        {
            return;
        }
        
        highScore = score;
        prefs.putInteger(HIGH_SCORE_KEY, highScore);
        prefs.flush();
    }
    
    public String getScoreString()
    {
        return Integer.toString(score);
    }
     public String getHighScoreString()
    {
        return Integer.toString(highScore);
    }
    
    
}

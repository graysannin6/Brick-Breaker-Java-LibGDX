package com.mygdx.game.config;

public final class GameConfig
{
    //constants / Desktop Only
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 760;
    
    public static final float HUD_WIDTH = 1024f; //world units
    public static final float HUD_HEIGHT = 760f; //world units

    public static final float WORLD_WIDTH = 32f; //world units
    public static final float WORLD_HEIGHT = 24f;//world units


    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2;//world units
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2;//world units

    public static final float PADDLE_MIN_WIDTH = 1.2f;
    public static final float PADDLE_MAX_WIDTH = 4.8f;
    public static final float PADDLE_START_WIDTH = 3f;
    public static final float PADDLE_HEIGHT = 1f;
    
    public static final float PADDLE_START_X = (WORLD_WIDTH - PADDLE_START_WIDTH) / 2;
    public static final float PADDLE_START_Y = 1f;
    
    public static final float PADDLE_VELOCITY_X = 15f;
    
    public static final float BRICK_WIDTH = 2.125f;
    public static final float BRICK_HEIGHT = 1f;
    
    public static final float LEFT_PAD = 0.5f;
    public static final float TOP_PAD = 1.9f;
    
    public static final float COLUMN_SPACING = 0.5f;
    public static final int COLUMN_COUNT = 12;
    
    public static final float ROW_SPACING = 0.5f;
    public static final int ROW_COUNT = 6;
    
    public static final float BALL_SIZE = 0.8f;
    public static final float BALL_HALF_SIZE = BALL_SIZE/2f;
    public static final float BALL_START_X = PADDLE_START_X + (PADDLE_START_WIDTH - BALL_SIZE) / 2;
    public static final float BALL_START_Y = PADDLE_START_Y + PADDLE_HEIGHT;
    public static final float BALL_START_VELOCITY = 15f;
    public static final float BALL_MIN_VELOCITY = 10f;
    public static final float BALL_MAX_VELOCITY = 22f;
    public static final float BALL_ACC = 0.15f;
      
    public static final float BALL_START_ANGLE = 60f;
    
    public static final int BRICK_SCORE = 10;
    
     public static final float POWER_UP_SIZE = 1f;
    
    public static final float PICKUP_SPAWN_TIME = 2f;
    public static final float PICKUP_VELOCITY_Y = -6f;
    public static float RESIZE_FACTOR = 0.15f;
    public static float EXPAND_SHRINK_SPEED = 6f;
    
    public static final int LIVES_START = 3;
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //constructor
    private GameConfig() {}
}

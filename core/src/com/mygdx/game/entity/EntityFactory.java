/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.entity;

import assets.AssetDescriptors;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.mygdx.game.config.GameConfig;

/**
 *
 * @author chris
 */
public class EntityFactory {
    
    private final AssetManager assetManager;
    
    private ParticleEffectPool fireEffectPool;
    
    private Pool<PowerUp> powerUpPool;
   

    public EntityFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
        init();
       
    }
    
    private void init() {
        ParticleEffect effect = assetManager.get(AssetDescriptors.FIRE);
        fireEffectPool = new ParticleEffectPool(effect, 5, 20);
        powerUpPool = Pools.get(PowerUp.class,10);
    }
    
    public Paddle createPaddle()
    {
        Paddle paddle = new Paddle();
        paddle.setPosition(GameConfig.PADDLE_START_X, GameConfig.PADDLE_START_Y);
        paddle.setSize(GameConfig.PADDLE_START_WIDTH, GameConfig.PADDLE_HEIGHT);
        return paddle;
    }
    
    public Array<Brick> createBricks()
    {
        Array<Brick> bricks = new Array<Brick>();
        
        float startX = GameConfig.LEFT_PAD;
        float startY = GameConfig.WORLD_HEIGHT - (GameConfig.TOP_PAD + GameConfig.BRICK_HEIGHT);
        
        for(int row = 0; row < GameConfig.ROW_COUNT;row++)
        {
            float brickY = startY - row * (GameConfig.ROW_SPACING + GameConfig.BRICK_HEIGHT);
            
            for(int column = 0; column < GameConfig.COLUMN_COUNT;column++)
            {
                float brickX = startX + column * (GameConfig.BRICK_WIDTH + GameConfig.COLUMN_SPACING);
                bricks.add(createBrick(brickX, brickY));
            }
        }
        
        return bricks;
    }
    
    public Ball createBall()
    {
        Ball ball = new Ball();
        ball.setPosition(GameConfig.BALL_START_X, GameConfig.BALL_START_Y);
        ball.setSize(GameConfig.BALL_SIZE);
        ball.setVelocity(GameConfig.BALL_START_ANGLE, GameConfig.BALL_START_VELOCITY);
        return ball;
    }
    
    private Brick createBrick(float x, float y)
    {
        Brick brick = new Brick();
        brick.setPosition(x, y);
        brick.setSize(GameConfig.BRICK_WIDTH, GameConfig.BRICK_HEIGHT);
        return brick;
    }
    
    public ParticleEffectPool.PooledEffect createFire(float x, float y)
    {
        ParticleEffectPool.PooledEffect effect = fireEffectPool.obtain();
        effect.setPosition(x, y);
        effect.start();
        return effect;
    }
    
    public PowerUp createPowerUp(float x, float y)
    {
        PowerUp powerUp = powerUpPool.obtain();
        powerUp.setType(PowerUpType.random());
        powerUp.setSize(GameConfig.POWER_UP_SIZE,GameConfig.POWER_UP_SIZE);
        powerUp.setPosition(x, y);
        powerUp.setVelocityY(GameConfig.PICKUP_VELOCITY_Y);
        return powerUp;
    }

    public void freePowerUp(PowerUp powerUp) {
       powerUpPool.free(powerUp);
    }
    
    public void freeAllPowerUp(Array<PowerUp> powerUps) {
       powerUpPool.freeAll(powerUps);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.entity;

import com.badlogic.gdx.math.Vector2;


import com.badlogic.gdx.utils.Pool.Poolable;
import util.entity.EntityBase;

/**
 *
 * @author chris
 */
public class PowerUp extends EntityBase implements Poolable {
    
    private PowerUpType type;
    private Vector2 velocity = new Vector2();

    public PowerUp() {
    }
    
    
    
    public PowerUp(PowerUpType type) {
        this.type = PowerUpType.random();
    }
    
    @Override
    public void update(float delta)
    {
        super.update(delta);
        setY(y+velocity.y * delta);
    }

    public void setType(PowerUpType type) {
        this.type = type;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
    
    
    
    public boolean isExpand(){
        return type.isExpand();
    }
    public boolean isShrink()
    {
        return type.isShrink();
    }
    public boolean isSppedUp()
    {
        return type.isSpeedUp();
    }
    public boolean isSlowDown()
    {
        return type.isSloswDown();
    }
    
    @Override
     public void reset() {
        type = null;
        velocity.setZero();
    }

   public void setVelocityY(float velocityY) {
       velocity.y = velocityY;
    }

    public PowerUpType getType() {
       return type;
    }
    
}

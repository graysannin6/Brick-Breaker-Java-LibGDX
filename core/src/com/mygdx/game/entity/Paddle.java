/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.entity;

import com.badlogic.gdx.math.Vector2;
import util.entity.EntityBase;


/**
 *
 * @author chris
 */
public class Paddle extends EntityBase {
    
    private Vector2 velocity = new Vector2();

    public Paddle() 
    {
        
    }
    @Override
    public void update(float delta)
    {
        super.update(delta);
        setX(x + velocity.x * delta);
    }
    
    public float getVelocityX()
    {
        return velocity.x;
    }
    
    public void setVelocityX(float velocityX)
    {
        velocity.x = velocityX;
    }
    
    
}

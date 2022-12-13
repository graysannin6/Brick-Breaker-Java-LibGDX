/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mygdx.game.entity;

import com.badlogic.gdx.utils.Array;





/**
 *
 * @author chris
 */
public enum PowerUpType {
    EXPAND,
    SHRINK,
    SLOW_DOWN,
    SPEED_UP;
   
    
    public boolean isExpand()
    {
        return this == EXPAND;
    }
    public boolean isShrink()
    {
        return this == SHRINK;
    }
    public boolean isSloswDown()
    {
        return this == SLOW_DOWN;
    }
    public boolean isSpeedUp()
    {
        return this == SPEED_UP;
    }
    
    public static PowerUpType random()
    {
        Array<PowerUpType> types = new Array<PowerUpType>(PowerUpType.values());
        types.shuffle();
        return types.random();
    }
    
}


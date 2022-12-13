/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.entity;

import com.mygdx.game.config.GameConfig;
import util.entity.EntityScriptBase;

/**
 *
 * @author chris
 */
public class PaddleShrink extends EntityScriptBase<Paddle>{

    private float finalWidth;
    private boolean shouldFinish;

    @Override
    public void added(Paddle entity) {
        super.added(entity); 
        float currentWidth = entity.getWidth();
        finalWidth = currentWidth - GameConfig.PADDLE_START_WIDTH * GameConfig.RESIZE_FACTOR;
        
        if (finalWidth <= GameConfig.PADDLE_MIN_WIDTH) {
            finalWidth = GameConfig.PADDLE_MIN_WIDTH;
        }
    }
    
    
    
    @Override
    public void update(float delta) {
        if (isFinished()) {
            return;
        }
        float currentWidth = entity.getWidth();
        float newWidth = currentWidth - GameConfig.EXPAND_SHRINK_SPEED * delta;
        
        if (newWidth <= finalWidth) {
            newWidth = finalWidth;
            shouldFinish = true;
        }
        entity.setWidth(newWidth);
        
        if (shouldFinish) {
            finish();
        }
    }
    
    
    
}

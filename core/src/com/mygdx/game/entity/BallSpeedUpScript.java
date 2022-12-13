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
public class BallSpeedUpScript extends EntityScriptBase<Ball> {
     private float finalSpeed;

    // == public methods ==
    @Override
    public void added(Ball entity) {
        super.added(entity);

        float currentSpeed = entity.getSpeed();
        finalSpeed = currentSpeed + GameConfig.BALL_START_VELOCITY * GameConfig.BALL_ACC;

        if(finalSpeed >= GameConfig.BALL_MAX_VELOCITY) {
            finalSpeed = GameConfig.BALL_MAX_VELOCITY;
        }
    }

    @Override
    public void update(float delta) {
        float angleDeg = entity.getAngleDeg();
        entity.setVelocity(angleDeg, finalSpeed);
        finish();
    }
}

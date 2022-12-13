/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.entity;

import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.config.GameConfig;
import util.entity.EntityScriptBase;

/**
 *
 * @author chris
 */
public class BallSlowDown extends EntityScriptBase<Ball>{

    
    private static final Logger log = new Logger(BallSlowDown.class.getName(), Logger.DEBUG);

    // == attributes ==
    private float finalSpeed;

    // == public methods ==
    @Override
    public void added(Ball entity) {
        super.added(entity);

        float currentSpeed = entity.getSpeed();
        finalSpeed = currentSpeed - GameConfig.BALL_START_VELOCITY * GameConfig.BALL_ACC;

        if (finalSpeed <= GameConfig.BALL_MIN_VELOCITY) {
            finalSpeed = GameConfig.BALL_MIN_VELOCITY;
        }
    }

    @Override
    public void update(float delta) {
        float angleDeg = entity.getAngleDeg();

        log.debug("speed before update= " + entity.getSpeed());

        entity.setVelocity(angleDeg, finalSpeed);

        log.debug("speed after update= " + entity.getSpeed());

        finish();
    }
    
}

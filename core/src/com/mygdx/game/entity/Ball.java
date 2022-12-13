/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.entity;


import shape.ShapeUtils;
import util.entity.EntityBase;

/**
 *
 * @author chris
 */
public class Ball extends EntityBase {

    public Ball() {
    }

    // == protected methods ==
    @Override
    protected float[] createVertices() {
        return ShapeUtils.createOctagon(
                width / 2f, // origin x or center r
                height / 2f, // origin y or center y
                width / 2f // radius
        );
    }
    
}

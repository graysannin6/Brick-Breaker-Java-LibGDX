/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game.game;

import assets.AssetDescriptors;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

/**
 *
 * @author chris
 */
public class SoundController {
        // == attributes ==
    private final AssetManager assetManager;

    private Sound hit;
    private Sound lost;
    private Sound pickup;

    // == constructors ==
    public SoundController(AssetManager assetManager) {
        this.assetManager = assetManager;
        init();
    }

    // == init ==
    private void init() {
        hit = assetManager.get(AssetDescriptors.HIT);
        lost = assetManager.get(AssetDescriptors.LOST);
        pickup = assetManager.get(AssetDescriptors.PICKUP);
    }

    // == public methods ==
    public void hit() {
        hit.play();
    }

    public void lost() {
        lost.play();
    }

    public void pickup() {
        pickup.play();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 *
 * @author chris
 */
public class AssetPacker {
    
    
    private static final String RAW_ASSETS_PATH = "src/com/mygdx/game/assets-raw";
    private static final String ASSETS_PATH = "core/assets";
    
    public static void main(String[] args)
    {
        TexturePacker.process(RAW_ASSETS_PATH + "/gameplay", ASSETS_PATH + "/gameplay","gameplay");
    }
}

package com.mygdx.game.screen;


import assets.AssetDescriptors;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.utils.Array;
import com.jga.util.game.GameBase;

import com.mygdx.game.config.GameConfig;
import util.loading.LoadingScreenBase;

public class LoadingScreen extends LoadingScreenBase {

    // == constructors ==
    public LoadingScreen(GameBase game) {
        super(game);
    }

    // == protected methods ==
   
   
    protected Array<AssetDescriptor> getAssetDescriptors() {
        return AssetDescriptors.ALL;
    }

   
   
    protected void onLoadDone() {
        game.setScreen(new GameScreen(game));
    }

  
   
    protected float getHudWidth() {
        return GameConfig.HUD_WIDTH;
    }

   
    
    protected float getHudHeight() {
        return GameConfig.HUD_HEIGHT;
    }
}

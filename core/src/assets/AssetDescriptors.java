/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author chris
 */
public final class AssetDescriptors {

    public static final AssetDescriptor<BitmapFont> Font =
            new AssetDescriptor<BitmapFont>(AssetPaths.SCORE_FONT,BitmapFont.class);
    
     public static final AssetDescriptor<TextureAtlas> GAME_PLAY =
             new AssetDescriptor<TextureAtlas>(AssetPaths.GAME_PLAY,TextureAtlas.class);
     
      public static final AssetDescriptor<ParticleEffect> FIRE =
             new AssetDescriptor<ParticleEffect>(AssetPaths.FIRE,ParticleEffect.class);
    
      public static final AssetDescriptor<Sound> HIT =
             new AssetDescriptor<Sound>(AssetPaths.HIT,Sound.class);
      
      public static final AssetDescriptor<Sound> LOST =
             new AssetDescriptor<Sound>(AssetPaths.LOST,Sound.class);
      
      public static final AssetDescriptor<Sound> PICKUP =
             new AssetDescriptor<Sound>(AssetPaths.PICKUP,Sound.class);
     
     public static final Array<AssetDescriptor> ALL = new Array<AssetDescriptor>();
     
     
     
     static{
         ALL.addAll(
         Font,
         GAME_PLAY,
         FIRE,
         HIT,
         LOST,
         PICKUP
         );
     }
     
    private AssetDescriptors() {
        
    }
    
    
    
    
    
}

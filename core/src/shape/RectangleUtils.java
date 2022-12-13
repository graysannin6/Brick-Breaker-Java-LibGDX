/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shape;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import util.Validate;

/**
 *
 * @author chris
 */
public class RectangleUtils 
{

    private RectangleUtils() 
    {
        
    }
    
    public static Vector2 getTopLeft(Rectangle rectangle)
    {
        Validate.notNull(rectangle);
        
        return new Vector2(rectangle.x,rectangle.y + rectangle.height);
    }
    
     public static Vector2 getTopRight(Rectangle rectangle)
    {
        Validate.notNull(rectangle);
        
        return new Vector2(rectangle.x + rectangle.width,rectangle.y + rectangle.height);
    }
       public static Vector2 getBottomLeft(Rectangle rectangle)
    {
        Validate.notNull(rectangle);
        
        return new Vector2(rectangle.x,rectangle.y);
    }
         public static Vector2 getBottomRight(Rectangle rectangle)
    {
        Validate.notNull(rectangle);
        
        return new Vector2(rectangle.x + rectangle.width,rectangle.y);
    }
    
}

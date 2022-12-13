/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.config.GameConfig;
import com.mygdx.game.entity.Paddle;

/**
 *
 * @author chris
 */
public class PaddleInputController {
    
    private final Paddle paddle;

    public PaddleInputController(Paddle paddle) {
        this.paddle = paddle;
    }
    
    public void update(float delta)
    {
        float velocityX = 0;
        
        
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A))
        {
            velocityX = -GameConfig.PADDLE_VELOCITY_X;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D))
        {
            velocityX = GameConfig.PADDLE_VELOCITY_X;
        }
        
        
        paddle.setVelocityX(velocityX);
    }
    
}

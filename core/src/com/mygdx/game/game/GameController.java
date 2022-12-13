package com.mygdx.game.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.config.GameConfig;
import com.mygdx.game.entity.Ball;
import com.mygdx.game.entity.BallSlowDown;
import com.mygdx.game.entity.BallSpeedUpScript;
import com.mygdx.game.entity.Brick;
import com.mygdx.game.entity.EntityFactory;
import com.mygdx.game.entity.Paddle;
import com.mygdx.game.entity.PaddleExpand;
import com.mygdx.game.entity.PaddleShrink;
import com.mygdx.game.entity.PowerUp;
import input.PaddleInputController;
import shape.RectangleUtils;

public class GameController {

    // == attributes ==
    private final ScoreController scoreController;
    private final EntityFactory factory;
    private final SoundController soundController;
    
    private Paddle paddle;
    public PaddleInputController paddleInputController;
    private Array<Brick> bricks = new Array<Brick>();
    private Ball ball;
    
    private int lives = GameConfig.LIVES_START;

    private boolean drawGrid = true;
    private boolean drawDebug = true;

    private Array<ParticleEffectPool.PooledEffect> effects = new Array<ParticleEffectPool.PooledEffect>();
    private Array<PowerUp> pickups = new Array<PowerUp>();

    // == constructors ==
    public GameController(SoundController soundController,ScoreController scoreController, EntityFactory factory) {
        this.soundController = soundController;
        this.scoreController = scoreController;
        this.factory = factory;
        init();
    }

    // == init ==
    private void init() {
        paddle = factory.createPaddle();
        paddleInputController = new PaddleInputController(paddle);

        ball = factory.createBall();

        startLevel();
    }
    
    public boolean isNotActiveAtTheStart = false;
            

    // == public methods ==
    public void update(float delta) {
        
        if (isGameOver()) {
            return;
        }
        
        if (ball.isNotActive() && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            activateBall();
        }

        if (ball.isNotActive()) {
            return;
        }

        // handle paddle input
        paddleInputController.update(delta);

        // update paddle
        paddle.update(delta);

        // block paddle from leaving the world
        blockPaddleFromLeavingTheWorld();

        // update ball
        ball.update(delta);

        // block ball from leaving the world
        blockBallFromLeavingTheWorld();

        // update pickups
        updatePickups(delta);

        // update effects
        updateEffects(delta);

        checkCollision();

        if (bricks.size == 0) {
            startLevel();
        }
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public Array<Brick> getBricks() {
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public Array<PowerUp> getPickups() {
        return pickups;
    }

    public Array<ParticleEffectPool.PooledEffect> getEffects() {
        return effects;
    }

    public String getScoreString() {
        return scoreController.getScoreString();
    }

    public boolean isDrawGrid() {
        return drawGrid;
    }

    public boolean isDrawDebug() {
        return drawDebug;
    }
    
    public boolean isGameOver()
    {
        return lives <= 0;
    }

    public int getLives() {
        return lives;
    }
    
    

    // == private methods ==
    private void handleDebugInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.F5)) {
            drawGrid = !drawGrid;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.F6)) {
            drawDebug = !drawDebug;
        }
    }

    private void blockPaddleFromLeavingTheWorld() {
        // block left
        if (paddle.getX() <= 0) {
            paddle.setX(0);
        }

        // block right
        float paddleRightX = paddle.getX() + paddle.getWidth();

        if (paddleRightX >= GameConfig.WORLD_WIDTH) {
            paddle.setX(GameConfig.WORLD_WIDTH - paddle.getWidth());
        }
    }

    private void blockBallFromLeavingTheWorld() {
        // bottom
        if (ball.getY() <= 0) {
            soundController.lost();
            lives--;
            restart();
            //ball.setY(0);
            //ball.multiplyVelocityY(-1);
        }

        // top
        float ballTop = ball.getY() + ball.getHeight();
        if (ballTop >= GameConfig.WORLD_HEIGHT) {
            ball.setY(GameConfig.WORLD_HEIGHT - ball.getHeight());
            ball.multiplyVelocityY(-1);
        }

        // left
        if (ball.getX() <= 0) {
            ball.setX(0);
            ball.multiplyVelocityX(-1);
        }

        // right
        float ballRight = ball.getX() + ball.getWidth();
        if (ballRight >= GameConfig.WORLD_WIDTH) {
            ball.setX(GameConfig.WORLD_WIDTH - ball.getWidth());
            ball.multiplyVelocityX(-1);
        }
    }

    private void updateEffects(float delta) {
        for (int i = 0; i < effects.size; i++) {
            ParticleEffectPool.PooledEffect effect = effects.get(i);
            effect.update(delta);

            if (effect.isComplete()) {
                effects.removeIndex(i);
                effect.free();
            }
        }
    }

    private void updatePickups(float delta) {
        for (int i = 0; i < pickups.size; i++) {
            PowerUp pickup = pickups.get(i);
            pickup.update(delta);

            if (pickup.getY() < -pickup.getHeight()) {
                factory.freePowerUp(pickup);
                pickups.removeIndex(i);
            }
        }
    }

    private void checkCollision() {
        checkBallWithPaddleCollision();
        checkBallWithBrickCollision();
        checkPaddleWithPickupCollision();
    }

    private void checkBallWithPaddleCollision() {
        Polygon ballBounds = ball.getBounds();
        Polygon paddleBounds = paddle.getBounds();

        if (Intersector.overlapConvexPolygons(ballBounds, paddleBounds)) {
            soundController.hit();
            float ballCenterX = ball.getX() + ball.getWidth() / 2f;
            float percent = (ballCenterX - paddle.getX()) / paddle.getWidth(); // 0f-1f
            // interpolate angle between 150 and 30
            float bounceAngle = 150 - percent * 120;
            ball.setVelocity(bounceAngle, ball.getSpeed());
        }
    }

    private void checkBallWithBrickCollision() {
        Polygon ballPolygon = ball.getBounds();
        float ballRadius = ball.getWidth() / 2f;
        Circle ballBounds = new Circle(
                ball.getX() + ballRadius,
                ball.getY() + ballRadius,
                ballRadius
        );


        for (int i = 0; i < bricks.size; i++) {
            Brick brick = bricks.get(i);
            Polygon brickPolygon = brick.getBounds();
            Rectangle brickBounds = brickPolygon.getBoundingRectangle();

            if (!Intersector.overlapConvexPolygons(ballPolygon, brickPolygon)) {
                continue;
            }
            
            soundController.hit();

            // check which side of brick is overlapping with ball
            Vector2 bottomLeft = RectangleUtils.getBottomLeft(brickBounds);
            Vector2 bottomRight = RectangleUtils.getBottomRight(brickBounds);
            Vector2 topLeft = RectangleUtils.getTopLeft(brickBounds);
            Vector2 topRight = RectangleUtils.getTopRight(brickBounds);

            Vector2 center = new Vector2(ballBounds.x, ballBounds.y);
            float squareRadius = ballBounds.radius * ballBounds.radius;

            boolean bottomHit = Intersector.intersectSegmentCircle(
                    bottomLeft, bottomRight, center, squareRadius
            );

            boolean topHit = Intersector.intersectSegmentCircle(
                    topLeft, topRight, center, squareRadius
            );

            boolean leftHit = Intersector.intersectSegmentCircle(
                    bottomLeft, topLeft, center, squareRadius
            );

            boolean rightHit = Intersector.intersectSegmentCircle(
                    bottomRight, topRight, center, squareRadius
            );


            // left - right
            if (ball.getVelocity().x > 0 && leftHit) {
                ball.multiplyVelocityX(-1);
            } else if (ball.getVelocity().x < 0 && rightHit) {
                ball.multiplyVelocityX(-1);
            }

            // bottom - top
            if (ball.getVelocity().y > 0 && bottomHit) {
                ball.multiplyVelocityY(-1);
            } else if (ball.getVelocity().y < 0 && topHit) {
                ball.multiplyVelocityY(-1);
            }

            // create fire effect
            float effectX = brick.getX() + brick.getWidth() / 2f;
            float y = brick.getY() + brick.getHeight() / 2f;

            spawnFireEffect(effectX, y);

//            if(MathUtils.random() < 0.2) {
            float pickupX = brick.getX() + (brick.getWidth() - GameConfig.POWER_UP_SIZE) / 2f;
                  spawnPickup(pickupX, y);
//            }

            // remove brick
            bricks.removeIndex(i);

            // add score
            scoreController.addScore(GameConfig.BRICK_SCORE);
            System.out.println("currentScore= " + scoreController.getScoreString());
        }
    }

    private void checkPaddleWithPickupCollision() {
        Polygon paddleBounds = paddle.getBounds();

        for (int i = 0; i < pickups.size; i++) {
            PowerUp pickup = pickups.get(i);
            Polygon pickupBounds = pickup.getBounds();

            if (Intersector.overlapConvexPolygons(paddleBounds, pickupBounds)) {
                soundController.pickup();
                addScript(pickup);
                pickups.removeIndex(i);
                factory.freePowerUp(pickup);
            }
        }
    }

    private void activateBall() {
        ball.setVelocity(GameConfig.BALL_START_ANGLE, GameConfig.BALL_START_VELOCITY);
    }

    private void startLevel() {
        restart();
        bricks.addAll(factory.createBricks());
    }

    private void spawnFireEffect(float x, float y) {
        ParticleEffectPool.PooledEffect effect = factory.createFire(x, y);
        effects.add(effect);
    }

    private void spawnPickup(float x, float y) {
        PowerUp pickup = factory.createPowerUp(x, y);
        pickups.add(pickup);
    }

    private void addScript(PowerUp pickup) {
        if (pickup.isExpand()) {
            paddle.addScript(new PaddleExpand());
        } else if (pickup.isShrink()) {
            paddle.addScript(new PaddleShrink());
        } 
        else if (pickup.isSlowDown()) {
            ball.addScript(new BallSlowDown());
        }
        else if (pickup.isSppedUp()) {
            ball.addScript(new BallSpeedUpScript());
        }
    }

    private void restart() {
        
        for (int i = 0; i < pickups.size; i++) {
            PowerUp pickup = pickups.get(i);
            factory.freePowerUp(pickup);
            pickups.removeIndex(i);
        }
        
         for (int i = 0; i < effects.size; i++) {
            ParticleEffectPool.PooledEffect effect = effects.get(i);
            effect.free();
            effects.removeIndex(i);
        }
        
        
        
        paddle.setPosition(GameConfig.PADDLE_START_X, GameConfig.PADDLE_START_Y);
        ball.setPosition(GameConfig.BALL_START_X, GameConfig.BALL_START_Y);
        ball.stop();
    }
    
}

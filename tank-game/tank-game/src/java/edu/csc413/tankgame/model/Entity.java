package edu.csc413.tankgame.model;
import edu.csc413.tankgame.view.RunGameView;


public abstract class Entity {

    private static final String SHELL_ID_PREFIX = "shell-";
    private static final double MOVEMENT_SPEED = 4.0;
    // private static final double MOVEMENT_SPEED = 2.0;
    private static final double TURN_SPEED = Math.toRadians(3);

    private final String id;
    private double x;
    private double y;
    private double angle;

    public Entity(String id, double x, double y, double angle) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public String getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public double getXBound(){
        return 0;
    }

    public double getYBound(){
        return 0;
    }

    public abstract void move(GameState gameState, RunGameView runGameView);

    // TODO: The methods below are provided so you don't have to do the math for movement. However, note that they are
    // protected. You should not be calling these methods directly from outside the Tank class hierarchy. Instead,
    // consider how to design your Tank class(es) so that a Tank can represent both a player-controlled tank and an AI
    // controlled tank.

    protected void moveForward() {
        x += MOVEMENT_SPEED * Math.cos(this.angle);
        y += MOVEMENT_SPEED * Math.sin(this.angle);
        checkBorder();
    }

    protected void moveBackward() {
        x -= MOVEMENT_SPEED * Math.cos(angle);
        y -= MOVEMENT_SPEED * Math.sin(angle);
        checkBorder();
    }

    protected void turnRightAI() {
        x += MOVEMENT_SPEED * Math.cos(90);
        y += MOVEMENT_SPEED * Math.cos(90);
    }

    protected void turnLeft() {
        angle -= TURN_SPEED;
    }

    protected void turnRight() {
        angle += TURN_SPEED;
    }

    private void checkBorder() {
        if (x < GameState.TANK_X_LOWER_BOUND) {
            x = GameState.TANK_X_LOWER_BOUND;
        } else if (x >= GameState.TANK_X_UPPER_BOUND) {
            x = GameState.TANK_X_UPPER_BOUND;
        } else if (y < GameState.TANK_Y_LOWER_BOUND) {
            y = GameState.TANK_Y_LOWER_BOUND;
        } else if (y >= GameState.TANK_Y_UPPER_BOUND) {
            y = GameState.TANK_Y_UPPER_BOUND;
        }
    }
}
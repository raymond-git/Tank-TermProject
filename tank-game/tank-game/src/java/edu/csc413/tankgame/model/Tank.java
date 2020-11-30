package edu.csc413.tankgame.model;


/**
 * Model class representing a tank in the game. A tank has a position and an angle. It has a movement speed and a turn
 * speed, both represented below as constants.
 */
// TODO: Notice that Tank has a lot in common with Shell. For full credit, you will need to find a way to share code
// between the two classes so that the logic for e.g. moveForward, etc. are not duplicated.
    public abstract class Tank extends Entity{
    private static final double MOVEMENT_SPEED = 2.0;
    private static final double TURN_SPEED = Math.toRadians(0.90);


    public Tank(String id, double x, double y, double angle){
        super(id, x, y, angle);
    }

    //public abstract void move(GameState gameState);

//    // TODO: The methods below are provided so you don't have to do the math for movement. However, note that they are
//    // protected. You should not be calling these methods directly from outside the Tank class hierarchy. Instead,
//    // consider how to design your Tank class(es) so that a Tank can represent both a player-controlled tank and an AI
//    // controlled tank.


    // The following methods will be useful for determining where a shell should be spawned when it
    // is created by this tank. It needs a slight offset so it appears from the front of the tank,
    // even if the tank is rotated. The shell should have the same angle as the tank.

    private double getShellX() {
        return getX() + 30.0 * (Math.cos(getAngle()) + 0.5);
    }

    private double getShellY() {
        return getY() + 30.0 * (Math.sin(getAngle()) + 0.5);
    }
}
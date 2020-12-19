package edu.csc413.tankgame.model;
import edu.csc413.tankgame.view.RunGameView;

/**
 * Model class representing a shell that has been fired by a tank. A shell has a position and an angle, as well as a
 * speed. Shells by default should be unable to turn and only move forward.
 */
// TODO: Notice that Shell has a lot in common with Tank. For full credit, you will need to find a way to share code
// between the two classes so that the logic for e.g. moveForward, etc. are not duplicated.
public class Shell extends Entity {
    private static final String SHELL_ID_PREFIX = "shell-";
    private static final double MOVEMENT_SPEED = 4.0;
    private static long uniqueId = 0L;

    public Shell( double x, double y, double angle) {
        super(getUniqueId(), x, y, angle);
    }

    public double getXBound(){
        return getX() + 24.0;
    }

    public double getYBound(){
        return getY() + 24.0;
    }

    @Override
    public void move(GameState gameState, RunGameView runGameView) {
            moveForward();
    }

    private static String getUniqueId() {
        return SHELL_ID_PREFIX + uniqueId++;
    }
}

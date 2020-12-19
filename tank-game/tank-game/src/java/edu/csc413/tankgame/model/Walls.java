//package edu.csc413.tankgame.model;
//
//import edu.csc413.tankgame.view.MainView;
//import edu.csc413.tankgame.view.RunGameView;
//
//public abstract class Walls extends Entity {
//    private static final String WALL_IMAGE_FILE_PREFIX = "wall-";
//    private static long uniqueId = 0L;
//
//    public Walls(String Wall_ID,double x, double y, double angle) {
//        super(getUniqueId(), x, y, angle);
//    }
//
//    private static String getUniqueId() {
//        return WALL_IMAGE_FILE_PREFIX + uniqueId++;
//    }
//
//
//    public void move(GameState gamestate) {
//
//    }

//}

package edu.csc413.tankgame.model;
import edu.csc413.tankgame.view.RunGameView;

public class Walls extends Entity {
    public static final String WALL_ID_PREFIX = "wall-";
    private static long uniqueId = 0L;

    public Walls(double x, double y) {
        super(getUniqueId(), x, y, 0);
    }


    public static String getUniqueId() {
        return WALL_ID_PREFIX + uniqueId++;
    }

    public void move(GameState gameState, RunGameView runGameView) {
    }

    public double getXBound() {
        return getX() + 32.0;
    }

    public double getYBound() {
        return getY() + 32.0;
    }
}





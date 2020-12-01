package edu.csc413.tankgame.model;

import edu.csc413.tankgame.view.MainView;

public class PlayerTank extends Tank {
    public PlayerTank(String id, double x, double y, double angle) {
        super(id, x, y, angle);
    }

    public void move(GameState gamestate) {
        if (MainView.pressUp) {
            moveForward();
        } else if (MainView.pressDown) {
            moveBackward();
        } else if (MainView.pressRight) {
            turnRight();
        } else if (MainView.pressLeft) {
            turnLeft();
        } else if (MainView.shoot) {
            //tryToFire(Shell);
        }
    }
}
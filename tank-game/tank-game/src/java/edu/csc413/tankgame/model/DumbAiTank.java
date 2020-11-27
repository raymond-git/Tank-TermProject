package edu.csc413.tankgame.model;

public class DumbAiTank extends Tank {
    public DumbAiTank(String id, double x, double y, double angle){
        super(id, x, y, angle);
    }
    @Override
    public void move(GameState gamestate){
        moveForward();
        turnRight();
    }

    @Override
    public void ClickPressUp() {

    }

    @Override
    public void ClickPressDown() {

    }

    @Override
    public void ClickPressRight() {

    }

    @Override
    public void ClickPressLeft() {

    }

    @Override
    public void ClickPressEscape() {

    }
}

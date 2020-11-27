package edu.csc413.tankgame.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerTank extends Tank{
    public PlayerTank(String id, double x, double y, double angle){
        super(id, x, y, angle);
}
@Override
    public void move(GameState gamestate){

        if(gamestate.ClickPressUp()){
            moveForward();
        }else if(gamestate.ClickPressDown()){
            moveBackward();
        }else if(gamestate.ClickPressRight()){
            turnRight();
        }else if(gamestate.ClickPressLeft()){
            turnLeft();
        }
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

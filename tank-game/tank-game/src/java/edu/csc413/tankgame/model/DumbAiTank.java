package edu.csc413.tankgame.model;

import edu.csc413.tankgame.view.MainView;

public class DumbAiTank extends Tank {
    public DumbAiTank(String id, double x, double y, double angle){
        super(id, x, y, angle);
    }
    @Override
    public void move(GameState gamestate) {
        if(MainView.pressUp == false) {
            turnLeft();
        }else if(MainView.pressDown == false){
            turnRight();
        }else if(MainView.pressLeft == false){
            moveForward();
        }else if(MainView.pressRight == false){
            turnRight();
        }
    }
}



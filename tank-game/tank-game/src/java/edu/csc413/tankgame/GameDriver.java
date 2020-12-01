package edu.csc413.tankgame;

import edu.csc413.tankgame.model.*;
import edu.csc413.tankgame.view.MainView;
import edu.csc413.tankgame.view.RunGameView;

/**
 * GameDriver is the primary controller class for the tank game. The game is launched from GameDriver.main, and
 * GameDriver is responsible for running the game loop while coordinating the views and the data models.
 */
public class GameDriver {
    // TODO: Implement.
    // Add the instance variables, constructors, and other methods needed for this class. GameDriver is the centerpiece
    // for the tank game, and should store and manage the other components (i.e. the views and the models). It also is
    // responsible for running the game loop.

    private static MainView mainView;
    private static RunGameView runGameView;
    private static GameState gameState;
    private static Object Shell;

    public GameDriver() {
        mainView = new MainView();
        runGameView = mainView.getRunGameView();
        gameState = new GameState();
    }

    public static void start() {
        // TODO: Implement.
        mainView.setScreen(MainView.Screen.START_MENU_SCREEN);
    }

    public static void RunGameScreen() {
        mainView.setScreen(MainView.Screen.RUN_GAME_SCREEN);
        runGame();
    }

    public static void EndGameScreen() {
        mainView.setScreen(MainView.Screen.END_MENU_SCREEN);
        System.exit(0);
    }

    private static void runGame() {
        Tank playerTank =
                new PlayerTank(
                        GameState.PLAYER_TANK_ID,
                        RunGameView.PLAYER_TANK_INITIAL_X,
                        RunGameView.PLAYER_TANK_INITIAL_Y,
                        RunGameView.PLAYER_TANK_INITIAL_ANGLE) {
                };

        Tank aiTank =
                new DumbAiTank(
                        GameState.AI_TANK_ID,
                        RunGameView.AI_TANK_INITIAL_X,
                        RunGameView.AI_TANK_INITIAL_Y,
                        RunGameView.AI_TANK_INITIAL_ANGLE) {
                };

        Tank shell =
                new DumbAiTank(
                        GameState.SHELL_ID,
                        RunGameView.SHELL_TANK_INITIAL_X,
                        RunGameView.SHELL_TANK_INITIAL_Y,
                        RunGameView.SHELL_TANK_INITIAL_Angle) {

                };

        gameState.addEntity(playerTank);
        gameState.addEntity(aiTank);
        gameState.addEntity(shell);

        runGameView.addDrawableEntity(
                GameState.PLAYER_TANK_ID,
                RunGameView.PLAYER_TANK_IMAGE_FILE,
                playerTank.getX(),
                playerTank.getY(),
                playerTank.getAngle());
        runGameView.addDrawableEntity(
                GameState.AI_TANK_ID,
                RunGameView.AI_TANK_IMAGE_FILE,
                aiTank.getX(),
                aiTank.getY(),
                aiTank.getAngle());
        runGameView.addDrawableEntity(
                GameState.SHELL_ID,
                RunGameView.SHELL_IMAGE_FILE,
                shell.getX(),
                shell.getY(),
                shell.getAngle());
        Runnable gameRunner = () -> {
            while (update()) {
                runGameView.repaint();
                try {
                    Thread.sleep(8L);
                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                }
            }
        };
        new Thread(gameRunner).start();
    }

    // TODO: Implement.
    // update should handle one frame of gameplay. All tanks and shells move one step, and all drawn entities
    // should be updated accordingly. It should return true as long as the game continues.
    private static boolean update() {
        //Ask all tanks, shells, etc to move
        for (Entity entity : gameState.getEntities()) {
            entity.move(gameState);
        }
        //Ask all tanks, shells, etc to check bounds
        for (Entity entity : gameState.getEntities()) {
            entity.move(gameState);
        }
        //Check collisions
        //for(everything in the game that is drawn){
        for (Entity entity : gameState.getEntities()) {
            runGameView.setDrawableEntityLocationAndAngle(entity.getId(), entity.getX(), entity.getY(), entity.getAngle());
        }
        return true;
    }

    public static void main(String[] args) {
        GameDriver gameDriver = new GameDriver();
        gameDriver.start();
    }
}

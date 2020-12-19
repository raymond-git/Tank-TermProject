//package edu.csc413.tankgame;
//import edu.csc413.tankgame.model.*;
//import edu.csc413.tankgame.view.MainView;
//import edu.csc413.tankgame.view.RunGameView;
//
///**
// * GameDriver is the primary controller class for the tank game. The game is launched from GameDriver.main, and
// * GameDriver is responsible for running the game loop while coordinating the views and the data models.
// */
//public class GameDriver {
//    // TODO: Implement.
//    // Add the instance variables, constructors, and other methods needed for this class. GameDriver is the centerpiece
//    // for the tank game, and should store and manage the other components (i.e. the views and the models). It also is
//    // responsible for running the game loop.
//
//    private static MainView mainView;
//    private static RunGameView runGameView;
//    private static GameState gameState;
//    private static Object Shell;
//
//    public GameDriver() {
//        mainView = new MainView();
//        runGameView = mainView.getRunGameView();
//        gameState = new GameState();
//    }
//
//    public static void start() {
//        // TODO: Implement.
//        mainView.setScreen(MainView.Screen.START_MENU_SCREEN);
//    }
//
//    public static void RunGameScreen() {
//        mainView.setScreen(MainView.Screen.RUN_GAME_SCREEN);
//        runGame();
//    }
//
//    public static void EndGameScreen() {
//        mainView.setScreen(MainView.Screen.END_MENU_SCREEN);
//        System.exit(0);
//    }
//
//    private static void runGame() {
//        Tank playerTank =
//                new PlayerTank(
//                        GameState.PLAYER_TANK_ID,
//                        RunGameView.PLAYER_TANK_INITIAL_X,
//                        RunGameView.PLAYER_TANK_INITIAL_Y,
//                        RunGameView.PLAYER_TANK_INITIAL_ANGLE) {
//                };
//
//        Tank aiTank =
//                new DumbAiTank(
//                        GameState.AI_TANK_ID,
//                        RunGameView.AI_TANK_INITIAL_X,
//                        RunGameView.AI_TANK_INITIAL_Y,
//                        RunGameView.AI_TANK_INITIAL_ANGLE) {
//                };
//
//        Entity wall =
//                new Walls(
//                        GameState.Wall_ID,
//                        RunGameView.WALL_IMAGE_INITIAL_X,
//                        RunGameView.WALL_IMAGE_INITIAL_Y,
//                        RunGameView.WALL_IMAGE_INITIAL_ANGLE) {
//                };
////        Tank shell =
////                new DumbAiTank(
////                        GameState.SHELL_ID,
////                        RunGameView.SHELL_TANK_INITIAL_X,
////                        RunGameView.SHELL_TANK_INITIAL_Y,
////                        RunGameView.SHELL_TANK_INITIAL_Angle) {
////
////                };
//
//        gameState.addEntity(playerTank);
//        gameState.addEntity(aiTank);
//        gameState.addEntity(wall);
//
//        // gameState.addEntity(shell);
//
//        runGameView.addDrawableEntity(
//                GameState.Wall_ID, GameState.PLAYER_TANK_ID,
//                RunGameView.PLAYER_TANK_IMAGE_FILE,
//                playerTank.getX(),
//                playerTank.getY(),
//                playerTank.getAngle());
//
//        runGameView.addDrawableEntity(
//                GameState.Wall_ID, GameState.AI_TANK_ID,
//                RunGameView.AI_TANK_IMAGE_FILE,
//                aiTank.getX(),
//                aiTank.getY(),
//                aiTank.getAngle());
//
//        runGameView.addDrawableEntity(
//                GameState.Wall_ID,
//                RunGameView.WALLS_IMAGE_FILE,
//                RunGameView.WALLS_IMAGE_FILEs,
//                wall.getX(),
//                wall.getY(),
//                wall.getAngle());
//
//
////        runGameView.addDrawableEntity(
////                GameState.SHELL_ID,
////                RunGameView.SHELL_IMAGE_FILE,
////                shell.getX(),
////                shell.getY(),
////                shell.getAngle());
//        Runnable gameRunner = () -> {
//            while (update()) {
//                runGameView.repaint();
//                try {
//                    Thread.sleep(8L);
//                } catch (InterruptedException exception) {
//                    throw new RuntimeException(exception);
//                }
//            }
//        };
//        new Thread(gameRunner).start();
//    }
//
//    // TODO: Implement.
//    // update should handle one frame of gameplay. All tanks and shells move one step, and all drawn entities
//    // should be updated accordingly. It should return true as long as the game continues.
//    private static boolean update() {
//        //Ask all tanks, shells, etc to move
//        for (Entity entity : gameState.getEntities()) {
//            entity.move(gameState);
//        }
//        //Ask all tanks, shells, etc to check bounds
////        for (Entity entity : gameState.getEntities()) {
////            entity.move(gameState);
////        }
//        //Check collisions
//
//
//        //for(everything in the game that is drawn){
//        for (Entity entity : gameState.getEntities()) {
//            runGameView.setDrawableEntityLocationAndAngle(entity.getId(), entity.getX(), entity.getY(), entity.getAngle());
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        GameDriver gameDriver = new GameDriver();
//        gameDriver.start();
//    }
//}

package edu.csc413.tankgame;

import edu.csc413.tankgame.model.*;
import edu.csc413.tankgame.view.MainView;
import edu.csc413.tankgame.view.RunGameView;
import edu.csc413.tankgame.WallImageInfo;

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

        for(WallImageInfo wallImage: WallImageInfo.readWalls()) {
            Walls wall =
                    new Walls(wallImage.getX(), wallImage.getY());
                        gameState.addEntity(wall);
                        runGameView.addDrawableEntity(
                             wall.getId(),
                             wallImage.getImageFile(),
                             wallImage.getX(),
                             wallImage.getY(),
                                 0);
        }

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

        Tank cushionTank =
                new CushionAiTank(
                        GameState.AI_TANK_ID2,
                        RunGameView.AI_TANK_2_INITIAL_X,
                        RunGameView.AI_TANK_2_INITIAL_Y,
                        RunGameView.AI_TANK_2_INITIAL_ANGLE){
                };

        gameState.addEntity(playerTank);
        gameState.addEntity(aiTank);
        gameState.addEntity(cushionTank);

        runGameView.addDrawableEntity(
                GameState.PLAYER_TANK_ID,
                RunGameView.PLAYER_TANK_IMAGE_FILE,
                playerTank.getX(),
                playerTank.getY(),
                playerTank.getAngle());

//        runGameView.addDrawableEntity(
//                GameState.AI_TANK_ID,
//                RunGameView.AI_TANK_IMAGE_FILE,
//                playerTank.getX(),
//                playerTank.getY(),
//                playerTank.getAngle());


        runGameView.addDrawableEntity(
                GameState.AI_TANK_ID,
                RunGameView.AI_TANK_IMAGE_FILE,
                cushionTank.getX(),
                cushionTank.getY(),
                cushionTank.getAngle());

//        runGameView.addDrawableEntity(
//                GameState.Wall_ID,
//                RunGameView.WALL_IMAGE_FILE,
//                wall.getX(),
//                wall.getY(),
//                wall.getAngle());

//        runGameView.addDrawableEntity(
//                GameState.SHELL_ID,
//                RunGameView.SHELL_IMAGE_FILE,
//                shell.getX(),
//                shell.getY(),
//                shell.getAngle());



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
//        for (Entity entity : gameState.getEntities()) {
//            entity.move(gameState, runGameView);
//        }

        //Get the number in the list
//        for(int i = 0; i < gameState.getEntities().size(); i++){
//            Entity entity = gameState.getEntities().get(i);
//            entity.move(gameState, runGameView);
//        }

        for(int i = 0; i < gameState.getEntities().size(); i++){
           for(int j = i+1; j < gameState.getEntities().size(); j++){
                if(entitiesOverlap(gameState.getEntities().get(i), gameState.getEntities().get(j)) ){
                        System.out.println("Detect Collision");
               }
           }
        }


        int tempEntity = gameState.getEntities().size();
        for (int i = 0; i < tempEntity; i++) {
            gameState.getEntities().get(i);
            gameState.getEntities().get(i).move(gameState, runGameView);
        }

        //Ask all tanks, shells, etc to check bounds


        //Check collisions
        //for(everything in the game that is drawn){
        for (Entity entity : gameState.getEntities()) {
            runGameView.setDrawableEntityLocationAndAngle(entity.getId(), entity.getX(), entity.getY(), entity.getAngle());
        }
        return true;
    }


    private static boolean entitiesOverlap(Entity entity1, Entity entity2) {
        return entity1.getX() < entity2.getXBound()
                && entity1.getXBound() > entity2.getX()
                && entity1.getY() < entity2.getYBound()
                && entity1.getYBound() > entity2.getY();
    }
        public static void main (String[]args){
            GameDriver gameDriver = new GameDriver();
            gameDriver.start();
        }
    }

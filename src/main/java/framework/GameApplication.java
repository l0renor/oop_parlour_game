package framework;

import framework.configuration.Configuration;
import framework.data.Board;
import framework.graphics.GraphicsEngine;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Java FX Application Class to run the game.
 * The configuration is passed in as a String argument.
 */
public class GameApplication extends Application {
    private static String launchArgs; //name of the configuration class

    public static void main(String[] args) {
        if(args.length == 1){
            launchArgs = args[0];
            launch(args);
        } else {
            throw new IllegalArgumentException("Please provide 1 arguement,the name of the configuration Class");
        }
    }

    @Override
    public void start(Stage primaryStage){

        Class<Configuration> configurationClass = null;
        Configuration conf = null;
        try {
            configurationClass = (Class<Configuration>) Class.forName(launchArgs);
            conf = configurationClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("The classname " + launchArgs + " was not found. Please provide a valid configuration class");
        }
        conf.configure();
        Board board = conf.getStartBoard();
        GraphicsEngine graphicsEngine = GraphicsEngine.getInstance();
        graphicsEngine.drawBoard(board, primaryStage);

        //@TODO  game.start
    }
}

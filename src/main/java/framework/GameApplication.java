package framework;

import framework.configuration.Configuration;
import framework.logic.Game;
import framework.configuration.GameMode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Java FX Application Class to start the game.
 * The configuration is passed in as a String argument.
 */
public class GameApplication extends Application {
    private static String launchArgs; //name of the configuration class

    public static void main(String[] args) {
        if (args.length == 1) {
            launchArgs = args[0];
            launch(args);
        } else {
            throw new IllegalArgumentException("Please provide 1 argument: the name of the configuration Class");
        }
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        Class<Configuration> configurationClass = null;
        Configuration conf = null;
        try {
            configurationClass = (Class<Configuration>) Class.forName(launchArgs);
            conf = configurationClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("The classname " + launchArgs + " was not found. Please provide a valid configuration class");
        }
        conf.configure();
        ArrayList<GameMode> gameModes = conf.getGameModes();
        runFromStartscreen(gameModes, primaryStage, conf.getStartScreenbackground());


    }

    private void runFromStartscreen(ArrayList<GameMode> gameModes, Stage s, String pathToBackground) {
        s.setTitle("Choose Gamemode");
        VBox vBox = new VBox(gameModes.size());
        vBox.setPadding(new Insets(145, 0, 0, 15));

        for (GameMode mode : gameModes) {
            Button b = new Button(mode.getName());
            b.setOnAction(event -> launchGame(mode, s));
            vBox.getChildren().add(b);
        }
        Image i = new Image(pathToBackground);


        vBox.setBackground(new Background(new BackgroundImage(i, null, null, null, new BackgroundSize(gameModes.get(0).getBoard().getWidth(), gameModes.get(0).getBoard().getHeight(), false, false, false, false))));
        Scene sc = new Scene(vBox, gameModes.get(0).getBoard().getWidth(), gameModes.get(0).getBoard().getHeight());
        s.setScene(sc);
        s.show();
    }

    private void launchGame(GameMode gameMode, Stage s) {
        new Game(gameMode, s);
    }
}

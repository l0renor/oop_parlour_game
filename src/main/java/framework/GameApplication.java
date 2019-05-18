package framework;

import framework.configuration.Configuration;
import framework.graphics.GraphicsEngine;
import framework.logic.GameMode;
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
 * Java FX Application Class to run the game.
 * The configuration is passed in as a String argument.
 */
public class GameApplication extends Application {
    private static String launchArgs; //name of the configuration class
    private static GameMode selectedGameMode;

    public static void main(String[] args) {
        if (args.length == 1) {
            launchArgs = args[0];
            launch(args);
        } else {
            throw new IllegalArgumentException("Please provide 1 arguement,the name of the configuration Class");
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
        runFromStartscreen(gameModes,primaryStage,conf.getStartScreenbackground());



    }

    private void runFromStartscreen(ArrayList<GameMode> gameModes, Stage s,String pathToBackground) {
        s.setTitle("creating buttons");
        VBox vBox = new VBox(gameModes.size());
        vBox.setPadding(new Insets(120,0,0,15));

        for (GameMode mode : gameModes) {
            Button b = new Button(mode.getName());
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    selectedGameMode = mode;
                    launchGame(mode,s);
                }
            });
            vBox.getChildren().add(b);
        }
        Image i = new Image(pathToBackground);


        vBox.setBackground(new Background(new BackgroundImage(i,null,null ,null,new BackgroundSize(500,700,false,false,false,false))));
        Scene sc = new Scene(vBox, 500, 700);
        s.setScene(sc);
        s.show();
    }
    private void launchGame(GameMode gameMode,Stage s){
        GraphicsEngine graphicsEngine = GraphicsEngine.getInstance();
        graphicsEngine.drawBoard(gameMode.getBoard(), s);
    }
}

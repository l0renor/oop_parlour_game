package framework;

import framework.data.Accessorie;
import framework.data.Board;
import framework.graphics.GraphicsEngine;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class GameApplication extends Application {//just ui

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Configuration all done here or loaded
        //start set up board
        //borad = boradbuiolder.build();
        final Board board = new Board(500.0, 500.0, 2, "background.bmp", "TestGame");
        board.addAccessorie(new Accessorie(100, 100, 100, 100, 2, "file:src/resources/grill.png")); // this should be done in the builder
        board.addAccessorie(new Accessorie(100, 100, 180, 230, 1, "file:src/resources/scorpion.png"));

        GraphicsEngine graphicsEngine = new GraphicsEngine();

        //this can be ein the main game loop
        primaryStage = graphicsEngine.drawBoard(board, primaryStage);
        primaryStage.show();
        // loop
    }

    private void drawShapes(GraphicsContext gc, List<Accessorie> accessories) {
        for (Accessorie acc : accessories) {
            Image accImg = new Image(acc.getPathToBackgground());
            gc.drawImage(accImg, acc.getPosX(), acc.getPosY(), acc.getSizeX(), acc.getSizeY());
        }

    }
}
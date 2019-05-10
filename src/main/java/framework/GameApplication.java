package framework;

import framework.data.Accessory;
import framework.data.Board;
import framework.data.TestAccessory;
import framework.data.TestLayout;
import framework.graphics.GraphicsEngine;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

public class GameApplication extends Application {//just ui

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final Board board = new TestLayout().createLayout();
        GraphicsEngine graphicsEngine = new GraphicsEngine();
        primaryStage = graphicsEngine.drawBoard(board, primaryStage);
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc, List<Accessory> accessories) {
        for (Accessory acc : accessories) {
            Image accImg = new Image(acc.getPathToBackgground());
            gc.drawImage(accImg, acc.getPosX(), acc.getPosY(), acc.getSizeX(), acc.getSizeY());
        }

    }
}
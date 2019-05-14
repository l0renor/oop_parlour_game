package framework;

import framework.configuration.Configuration;
import framework.data.accessories.Accessory;
import framework.data.Board;
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
    public void start(Stage primaryStage) throws IllegalAccessException, InstantiationException {
        Class<Configuration> configurationClass = null;
        try {
            configurationClass = (Class<Configuration>) Class.forName("framework.configuration.TestConfiguration");
        } catch (ClassNotFoundException e) {
            //TODO handling 4 real
            e.printStackTrace();
        }
        Configuration conf = configurationClass.newInstance();
        conf.configureBoard();
        Board board = conf.getBoard();
        GraphicsEngine graphicsEngine = GraphicsEngine.getInstance();
        primaryStage = graphicsEngine.drawBoard(board, primaryStage);
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc, List<Accessory> accessories) {
        for (Accessory acc : accessories) {
            Image accImg = new Image(acc.getPathToImage());
            gc.drawImage(accImg, acc.getPosX(), acc.getPosY(), acc.getWidth(), acc.getHeight());
        }

    }
}

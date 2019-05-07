package Graphics.Board;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class GameApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Configuration all done here or loaded
        BoardData boardData = new BoardData(500.0,500.0,2,"foo","TestGame");
        primaryStage.setTitle(boardData.getGameName());
        Group root = new Group();
        javafx.scene.canvas.Canvas canvas = new javafx.scene.canvas.Canvas(boardData.getSizeX(), boardData.getSizeY());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        Image testimg = new Image("file:src/resources/scorp2.jpg");
        gc.drawImage(testimg,250, 250,60,60);
    }
}
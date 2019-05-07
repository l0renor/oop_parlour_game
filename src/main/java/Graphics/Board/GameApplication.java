package Graphics.Board;

import Graphics.accessories.Accessorie;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.List;

public class GameApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Configuration all done here or loaded
        //start set up board
        BoardData boardData = new BoardData(500.0,500.0,2,"foo","TestGame");
        boardData.addAccessorie(new Accessorie(100, 100, 230, 230, 1, "file:src/resources/scorp2.jpg") {
            @Override
            public void onClick() {

            }
        });
        boardData.addAccessorie(new Accessorie(100, 100, 80, 80, 1, "file:src/resources/scorpion.png") {
            @Override
            public void onClick() {

            }
        });
        //end set up board
        primaryStage.setTitle(boardData.getGameName());
        Group root = new Group();
        javafx.scene.canvas.Canvas canvas = new javafx.scene.canvas.Canvas(boardData.getSizeX(), boardData.getSizeY());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc,boardData);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc,BoardData boardData) {
        List<Accessorie> accessories = boardData.getAccessories();
        for(Accessorie acc : accessories){
            Image testimg = new Image(acc.getPathToBackgground());
            gc.drawImage(testimg,acc.getPosX(), acc.getPosY(),acc.getSizeX(),acc.getSizeY());
        }

    }
}
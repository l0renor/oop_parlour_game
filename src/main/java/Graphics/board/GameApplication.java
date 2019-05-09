package Graphics.board;

import Graphics.accessories.Accessorie;
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

public class GameApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Configuration all done here or loaded
        //start set up board
        final BoardData boardData = new BoardData(500.0, 500.0, 2, "background.bmp", "TestGame");
        boardData.addAccessorie(new Accessorie(100, 100, 100, 100, 2, "file:src/resources/grill.png") {
            @Override
            public void onClick() {
                System.out.println("Grill");
            }
        });
        boardData.addAccessorie(new Accessorie(100, 100, 180, 230, 1, "file:src/resources/scorpion.png") {
            @Override
            public void onClick() {
                System.out.println("Scorpion");
            }
        });
        //end set up board
        primaryStage.setTitle(boardData.getGameName());
        Group root = new Group();
        Canvas background = new Canvas(boardData.getSizeX(), boardData.getSizeY());
        GraphicsContext gc = background.getGraphicsContext2D();
        Image backgroundImg = new Image(boardData.getPathToBackgground());
        gc.drawImage(backgroundImg, 0, 0, boardData.getSizeX(), boardData.getSizeY());
        root.getChildren().add(background);
        int currentLayernum = 1;
        //@TODO only works on top layer needs to be fixed
        //@TODO layers are haveoffset
        for (final List<Accessorie> layer : boardData.getAccessoriesByLayer()) {
            Canvas canvas = new Canvas(boardData.getSizeX(), boardData.getSizeY());
            if (currentLayernum == boardData.getNumLayers()+1) { //only top layer need event handler
                canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        //check if a accessorie on this layer was clicked
                        new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent e) {
                                for (final List<Accessorie> currentLayer : boardData.getAccessoriesByLayer()) {
                                    for (Accessorie accessorie : currentLayer) {
                                        //IF accessorie was clicked call onclick
                                        if ((accessorie.getPosX() < e.getSceneX() && e.getSceneX() < (accessorie.getPosX() + accessorie.getSizeX()))
                                                && (accessorie.getPosY() < e.getSceneY() && e.getSceneY() < (accessorie.getPosY() + accessorie.getSizeY()))) {
                                            accessorie.onClick();
                                            return;
                                        }
                                    }
                                }
                            }
                        });
            }
            GraphicsContext layerGc = canvas.getGraphicsContext2D();
            drawShapes(layerGc, layer);
            root.getChildren().add(canvas);
            currentLayernum++;
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc, List<Accessorie> accessories) {
        for (Accessorie acc : accessories) {
            Image accImg = new Image(acc.getPathToBackgground());
            gc.drawImage(accImg, acc.getPosX(), acc.getPosY(), acc.getSizeX(), acc.getSizeY());
        }

    }
}
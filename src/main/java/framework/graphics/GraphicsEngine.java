package framework.graphics;

import framework.data.Board;
import framework.data.Point;
import framework.data.accessories.Accessory;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;

public class GraphicsEngine extends Observable {

    private static GraphicsEngine ourInstance = new GraphicsEngine();

    private GraphicsEngine() {}

    public static GraphicsEngine getInstance() {
        return ourInstance;
    }

    /**
     * Draws the board on the given stage
     * @param board the board to be drawn
     * @param stage the stage to draw on
     * @return the stage with the board drawn on it
     */
    public void drawBoard(Board board, Stage stage) {
        Group root = new Group();
        Canvas background = new Canvas(board.getWidth(), board.getHeight());
        GraphicsContext graphicsContext = background.getGraphicsContext2D();
        Image backgroundImg = new Image(board.getPathToBackground());
        graphicsContext.drawImage(backgroundImg, 0, 0, board.getWidth(), board.getHeight());
        root.getChildren().add(background);
        int currentLayernum = 1;
        //@TODO layers are haveoffset
        for (final List<Accessory> layer : board.getAccessoriesByLayer()) {
            Canvas canvas = new Canvas(board.getWidth(), board.getHeight());
            if (currentLayernum == board.getNumLayers() + 1) { //only top layer need event handler
                canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        e -> {
                            setChanged();
                            notifyObservers(new Point(e.getSceneX(),e.getSceneY()));
                        });
            }
            GraphicsContext layerGc = canvas.getGraphicsContext2D();
            drawShapes(layerGc, layer);
            root.getChildren().add(canvas);
            currentLayernum++;
        }
        BorderPane border = new BorderPane();
        TextArea ta = new TextArea(board.getInfoText());
        ta.setEditable(false);
        border.setTop(root);
        border.setBottom(ta);
        stage.setScene(new Scene(border));
        stage.setTitle(board.getGameName());
        stage.getIcons().add(new Image(board.getPathToIcon()));
        stage.show();
    }

    private void drawShapes(GraphicsContext gc, List<Accessory> accessories) {
        for (Accessory acc : accessories) {
            Image accImg = new Image(acc.getPathToImage());
            gc.drawImage(accImg, acc.getPosX(), acc.getPosY(), acc.getWidth(), acc.getHeight());
        }
    }


}

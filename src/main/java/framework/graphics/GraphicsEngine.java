package framework.graphics;

import framework.data.Accessory;
import framework.data.Board;
import framework.data.Point;
import javafx.event.EventHandler;
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
    private Point lastclick;

    /**
     * Draws the board on the given stage
     * @param board the board to be drawn
     * @param stage the stage to draw on
     * @return the stage with the board drawn on it
     */
    public Stage drawBoard(Board board, Stage stage) {
        Group root = new Group();
        Canvas background = new Canvas(board.getWidth(), board.getHeight());
        GraphicsContext gc = background.getGraphicsContext2D();
        Image backgroundImg = new Image(board.getPathToBackground());
        gc.drawImage(backgroundImg, 0, 0, board.getWidth(), board.getHeight());
        root.getChildren().add(background);
        int currentLayernum = 1;
        //@TODO layers are haveoffset
        for (final List<Accessory> layer : board.getAccessoriesByLayer()) {
            Canvas canvas = new Canvas(board.getWidth(), board.getHeight());
            if (currentLayernum == board.getNumLayers() + 1) { //only top layer need event handler
                canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent e) {
                                notifyObservers(new Point(e.getSceneX(),e.getSceneY()));
                                System.out.println("obersre is notified");
                                return;
                            }


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
        return stage;
    }

    private void drawShapes(GraphicsContext gc, List<Accessory> accessories) {
        for (Accessory acc : accessories) {
            Image accImg = new Image(acc.getPathToImage());
            gc.drawImage(accImg, acc.getPosX(), acc.getPosY(), acc.getSizeX(), acc.getSizeY());
        }

    }


}

   /*
      @TODO add this to logic
      for (final List<Accessory> currentLayer : board.getAccessoriesByLayer()) {
        for (Accessory accessorie : currentLayer) {
        //IF accessorie was clicked call onclick
        if ((accessorie.getPosX() < e.getSceneX() && e.getSceneX() < (accessorie.getPosX() + accessorie.getWidth()))
        && (accessorie.getPosY() < e.getSceneY() && e.getSceneY() < (accessorie.getPosY() + accessorie.getHeight()))) {
        accessorie.onClick();*/

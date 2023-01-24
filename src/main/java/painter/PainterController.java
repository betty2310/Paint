package painter;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;


public class PainterController implements Initializable {
    public ToggleButton btPen;
    public ToggleButton btErase;
    private GraphicsContext gc;
    public Button btSave;
    public Button btOpen;
    public Button btHelp;
    public Button btClear;
    public Button btUndo;
    public Button btRedo;
    public Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
    }

    public void clearCanvas(ActionEvent actionEvent) {
        btPen.setSelected(false);
        btErase.setSelected(false);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void undoCanvas(ActionEvent actionEvent) {
    }
    public void redoCanvas(ActionEvent actionEvent) {
    }

    public void toggleErase(ActionEvent actionEvent) {
        if(btErase.isSelected()) {
            btPen.setSelected(false);
        }
    }

    public void togglePen(ActionEvent actionEvent) {
        if(btPen.isSelected()) {
            btErase.setSelected(false);
        }
    }
    public void setOnMousePressed(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
            gc.setStroke(javafx.scene.paint.Color.BLACK);
            gc.setLineWidth(1);
            gc.beginPath();
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
        }
        if(btErase.isSelected()) {
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(10);
            gc.beginPath();
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void setOnMouseDragged(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
            gc.stroke();
        }
        if (btErase.isSelected()) {
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
            gc.stroke();
        }
    }

    public void setOnMouseReleased(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
            gc.stroke();
            gc.closePath();
        }
        if (btErase.isSelected()) {
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
            gc.stroke();
            gc.closePath();
        }
    }
}

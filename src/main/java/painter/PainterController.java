package painter;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class PainterController implements Initializable {
    public ToggleButton btPen;
    private GraphicsContext gc;
    public Button btSave;
    public Button btOpen;
    public Button btHelp;
    public Button btClear;
    public Button btUndo;
    public Button btRedo;
    public Canvas canvas;

    public void togglePen(ActionEvent actionEvent) {
    }
    public void setOnMousePressed(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
            gc.setStroke(javafx.scene.paint.Color.BLACK);
            gc.beginPath();
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void setOnMouseDragged(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
    }

}

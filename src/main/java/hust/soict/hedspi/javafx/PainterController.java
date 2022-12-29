package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton btPen;
    @FXML
    private RadioButton btErase;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = btPen.isSelected() ? Color.BLACK : Color.WHITE;
        Double radius = btPen.isSelected() ? 3.0 : 6.0;
        Circle circle = new Circle(event.getX(), event.getY(), radius, color);
        drawingAreaPane.getChildren().add(circle);
    }

    public void btPenPressed(ActionEvent actionEvent) {
        if (btPen.isSelected()) {
            btErase.setSelected(false);
        }
    }

    public void btEraserPressed(ActionEvent actionEvent) {
        if(btErase.isSelected()) {
            btPen.setSelected(false);
        }
    }
}

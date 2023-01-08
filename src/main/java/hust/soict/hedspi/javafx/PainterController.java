package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
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
    public ColorPicker selectColor;
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
        Color color = Color.WHITE;
        Double radius = 6.0;
        if(btPen.isSelected()) {
            color = selectColor.getValue();
            radius = 3.0;
        }
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

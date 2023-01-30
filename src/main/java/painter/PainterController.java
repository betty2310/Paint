package painter;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PainterController implements Initializable {
    public ToggleButton btPen;
    public ToggleButton btErase;
    public ColorPicker foregroundColor;
    public BorderPane pane;
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
        gc.setLineWidth(0);
        btPen.setSelected(false);
        btErase.setSelected(false);
    }

    public void clearCanvas(ActionEvent actionEvent) {
        btPen.setSelected(false);
        btErase.setSelected(false);
        setImageCursor("default");
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void undoCanvas(ActionEvent actionEvent) {
    }

    public void redoCanvas(ActionEvent actionEvent) {
    }

    public void toggleErase(ActionEvent actionEvent) {
        if (btErase.isSelected()) {
            btPen.setSelected(false);
        }
    }

    public void togglePen(ActionEvent actionEvent) {
        if (btPen.isSelected()) {
            btErase.setSelected(false);
        }
    }

    public void setOnMousePressed(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
            setImageCursor("pen");
            drawOnMousePressed(foregroundColor.getValue(), 1, mouseEvent.getX(), mouseEvent.getY());
        }
        if (btErase.isSelected()) {
            setImageCursor("erase");
            drawOnMousePressed(Color.WHITE, 10, mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void setOnMouseDragged(MouseEvent mouseEvent) {
        if (btPen.isSelected() || btErase.isSelected()) {
            drawOnMouseDragged(mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void setOnMouseReleased(MouseEvent mouseEvent) {
        if (btPen.isSelected() || btErase.isSelected()) {
            drawOnMouseReleased(mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void drawOnMousePressed(Color color, double width, double x, double y) {
        gc.setStroke(color);
        gc.setLineWidth(width);
        gc.beginPath();
        gc.lineTo(x, y + 20);
    }

    public void drawOnMouseDragged(double x, double y) {
        gc.lineTo(x, y + 20);
        gc.stroke();
    }

    public void drawOnMouseReleased(double x, double y) {
        gc.lineTo(x, y + 20);
        gc.stroke();
        gc.closePath();
    }

    public void setOnMouseEntered(MouseEvent mouseEvent) {
        if (btPen.isSelected()) {
            setImageCursor("pen");
        }
        if (btErase.isSelected()) {
            setImageCursor("erase");
        }
    }

    public void setOnMouseExited(MouseEvent mouseEvent) {
        setImageCursor("default");
    }

    public void setImageCursor(String name) {
        if (name.equals("default")) {
            canvas.setCursor(Cursor.DEFAULT);
        } else {
            canvas.setCursor(new ImageCursor(new Image(getClass().getResourceAsStream("/icons/" + name + ".png"))));
        }
    }

    public void saveToFile(ActionEvent actionEvent) {
        FileChooser save = new FileChooser();
        save.setTitle("Save file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files", "*.png");
        save.getExtensionFilters().add(extFilter);

        Stage stage = (Stage) pane.getScene().getWindow();
        File file = save.showSaveDialog(stage);
        if (file != null) {
            WritableImage writableImage = new WritableImage(1271, 583);
            canvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            try {
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException e) {
                System.out.println("Error!");
            }
        }

    }
}

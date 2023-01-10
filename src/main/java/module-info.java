module hust.soict.hedspi.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens painter to javafx.fxml;
    exports painter;
}
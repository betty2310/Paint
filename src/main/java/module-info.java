module hust.soict.hedspi.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;


    opens painter to javafx.fxml;
    exports painter;
}
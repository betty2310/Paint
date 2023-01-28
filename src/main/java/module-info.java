module hust.soict.hedspi.javafx {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.swing;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.desktop;


    opens painter to javafx.fxml;
    exports painter;
}
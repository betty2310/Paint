module hust.soict.hedspi.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens hust.soict.hedspi.javafx to javafx.fxml;
    exports hust.soict.hedspi.javafx;
}
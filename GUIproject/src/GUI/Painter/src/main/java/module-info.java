module com.example.painter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens painter to javafx.fxml;
    exports JavaFX;
}
module com.sandysystems.codigop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.sandysystems.codigop.controller to javafx.fxml;
    exports com.sandysystems.codigop;
}
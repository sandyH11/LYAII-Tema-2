package com.sandysystems.codigop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import com.sandysystems.codigop.model.codigoIntermedio;
import com.sandysystems.codigop.service.codigoIntermedioService;

public class codigoPController {

    @FXML private TextArea taCodigoFuente;
    @FXML private TextArea taCodigoIntermedio;
    @FXML private Button btnGenerar;
    @FXML private Button btnLimpiar;

    private final codigoIntermedioService service = new codigoIntermedioService();

    @FXML
    public void initialize() {
        btnGenerar.setOnAction(e -> generarCodigo());
        btnLimpiar.setOnAction(e -> limpiar());
    }

    private void generarCodigo() {
        String fuente = taCodigoFuente.getText();
        if (fuente.isBlank()) {
            mostrarAlerta("Ingrese código fuente.");
            return;
        }

        codigoIntermedio ci = service.generateFromSource(fuente);
        taCodigoIntermedio.setText(ci.toString());
    }

    private void limpiar() {
        taCodigoFuente.clear();
        taCodigoIntermedio.clear();
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
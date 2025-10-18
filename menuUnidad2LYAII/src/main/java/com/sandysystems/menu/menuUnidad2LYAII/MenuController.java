package com.sandysystems.menu.menuUnidad2LYAII;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;

public class MenuController {

    @FXML
    private StackPane content;

    @FXML
    private void abrirProyecto1() {
        cargarVista("/com/sandysystems/menu/proyecto1/proyecto1.fxml");
    }

    @FXML
    private void abrirProyecto2() {
        cargarVista("/com/sandysystems/menu/proyecto2/proyecto2.fxml");
    }
    @FXML
    private void abrirProyecto3() {
        cargarVista("/com/sandysystems/menu/proyecto3/proyecto3.fxml");
    }
    @FXML
    private void abrirProyecto4() {
        cargarVista("/com/sandysystems/menu/proyecto4/proyecto4.fxml");
    }
    @FXML
    private void abrirProyecto5() {
        cargarVista("/com/sandysystems/menu/proyecto5/proyecto5.fxml");
    }
    @FXML
    private void abrirProyecto6() {
        cargarVista("/com/sandysystems/menu/proyecto6/proyecto6.fxml");
    }
    @FXML
    private void abrirProyecto7() {
        cargarVista("/com/sandysystems/menu/proyecto7/proyecto7.fxml");
    }
    @FXML
    private void abrirProyecto8() {
        cargarVista("/com/sandysystems/menu/proyecto8/proyecto8.fxml");
    }
    @FXML
    private void abrirProyecto9() {
        cargarVista("/com/sandysystems/menu/proyecto9/proyecto9.fxml");
    }
    @FXML
    private void abrirProyecto10() {
        cargarVista("/com/sandysystems/menu/proyecto10/proyecto10.fxml");
    }
    @FXML
    private void abrirProyecto11() {cargarVista("/com/sandysystems/menu/proyecto11/proyecto11.fxml");}


    private void cargarVista(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();
            content.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No se pudo cargar la vista");
            alert.setContentText("Revisa la ruta del FXML: " + fxmlPath);
            alert.showAndWait();
        }
    }
}

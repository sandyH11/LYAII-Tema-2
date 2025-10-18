package com.sandysystems.menu.proyecto2;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Proyecto2Controller {

    public static class Cuadruplo {
        private final String op, arg1, arg2, res;
        public Cuadruplo(String op, String arg1, String arg2, String res) {
            this.op = op; this.arg1 = arg1; this.arg2 = arg2; this.res = res;
        }
        public String getOp()  { return op; }
        public String getArg1(){ return arg1; }
        public String getArg2(){ return arg2; }
        public String getRes() { return res; }
    }

    private final ObservableList<Cuadruplo> data = FXCollections.observableArrayList();

    @FXML private TextField txtExpresion;
    @FXML private TableView<Cuadruplo> tabla;
    @FXML private TableColumn<Cuadruplo, String> colOp, colArg1, colArg2, colRes;

    @FXML
    private void initialize() {
        colOp.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getOp()));
        colArg1.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getArg1()));
        colArg2.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getArg2()));
        colRes.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRes()));
        tabla.setItems(data);
    }

    @FXML
    private void generar() {
        data.clear();
        String expresion = txtExpresion.getText() == null ? "" : txtExpresion.getText().trim();

        if (expresion.equalsIgnoreCase("a = b + c * d")) {
            data.add(new Cuadruplo("*", "c", "d", "t1"));
            data.add(new Cuadruplo("+", "b", "t1", "t2"));
            data.add(new Cuadruplo("=", "t2", "-", "a"));
        } else if (expresion.equalsIgnoreCase("a = b + c")) {
            data.add(new Cuadruplo("+", "b", "c", "t1"));
            data.add(new Cuadruplo("=", "t1", "-", "a"));
        } else {
            new Alert(Alert.AlertType.INFORMATION,
                    "Ejemplo no soportado todavía.\nPrueba con 'a = b + c * d' o 'a = b + c'.",
                    ButtonType.OK
            ).showAndWait();
        }
    }
}

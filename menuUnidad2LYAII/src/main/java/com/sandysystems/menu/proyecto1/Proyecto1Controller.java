package com.sandysystems.menu.proyecto1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Proyecto1Controller {

    @FXML
    private TextField inputField;

    @FXML
    private ComboBox<String> notationBox;

    @FXML
    private TextArea resultArea;

    private NotacionConverter converter = new NotacionConverter();
    private IntermediateCodeGenerator codeGen = new IntermediateCodeGenerator();

    @FXML
    public void initialize() {
        notationBox.getItems().addAll("Prefija", "Infija", "Postfija");
        notationBox.setValue("Infija");
    }

    @FXML
    private void processExpression() {
        String expression = inputField.getText();
        String choice = notationBox.getValue();

        StringBuilder result = new StringBuilder();

        // Mostrar la expresión en distintas notaciones
        result.append("Expresión original (Infija): ").append(expression).append("\n");
        result.append("Prefija: ").append(converter.infijaAPrefija(expression)).append("\n");
        result.append("Postfija: ").append(converter.infijaAPostfija(expression)).append("\n");

        // Generar código intermedio
        result.append("\nCódigo intermedio:\n");
        result.append(codeGen.generarCodigo(expression));

        resultArea.setText(result.toString());
    }
}
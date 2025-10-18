package com.sandysystems.menu.proyecto1;


import java.util.Stack;

public class IntermediateCodeGenerator {

    public String generarCodigo(String exp) {
        // Verificamos si hay asignación
        String varAsignacion = null;
        String expresion = exp;

        if (exp.contains("=")) {
            String[] partes = exp.split("=");
            varAsignacion = partes[0].trim();
            expresion = partes[1].trim();  // solo tomamos la parte derecha
        }

        String postfija = new NotacionConverter().infijaAPostfija(expresion);
        Stack<String> stack = new Stack<>();
        StringBuilder codigo = new StringBuilder();
        int tempCount = 1;

        for (char c : postfija.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                // aseguramos que haya suficientes operandos
                if (stack.size() < 2) {
                    return "Error: expresión inválida en código intermedio.\n";
                }
                String op2 = stack.pop();
                String op1 = stack.pop();
                String temp = "t" + tempCount++;
                codigo.append(temp).append(" = ").append(op1).append(" ").append(c).append(" ").append(op2).append("\n");
                stack.push(temp);
            }
        }

        // Si había asignación, el resultado final se guarda en la variable original
        if (varAsignacion != null && !stack.isEmpty()) {
            String ultimaTemp = stack.pop();
            codigo.append(varAsignacion).append(" = ").append(ultimaTemp).append("\n");
        }

        return codigo.toString();
    }
}

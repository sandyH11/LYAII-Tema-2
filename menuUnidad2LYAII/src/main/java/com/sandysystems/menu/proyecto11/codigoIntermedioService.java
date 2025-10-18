package com.sandysystems.menu.proyecto11;

import com.sandysystems.menu.proyecto11.codigoIntermedio.Instruction;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class codigoIntermedioService {

    private int tempCount = 0;

    public codigoIntermedio generateFromSource(String source) {
        codigoIntermedio ic = new codigoIntermedio();
        tempCount = 0;

        // Limpieza básica
        source = source.replaceAll("\\s+", "");
        if (source.isEmpty()) return ic;

        // Soporta múltiples líneas
        String[] lines = source.split(";");
        for (String line : lines) {
            if (line.isBlank()) continue;
            processLine(line, ic);
        }

        return ic;
    }

    private void processLine(String line, codigoIntermedio ic) {
        // ejemplo: a=b+c*d
        String[] parts = line.split("=");
        if (parts.length != 2) return;

        String res = parts[0];
        String expr = parts[1];

        String postfix = infixToPostfix(expr);
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else if ("+-*/".indexOf(c) != -1) {
                String b = stack.pop();
                String a = stack.pop();
                String t = newTemp();
                ic.add(new Instruction(String.valueOf(c), a, b, t));
                stack.push(t);
            }
        }

        if (!stack.isEmpty()) {
            String t = stack.pop();
            ic.add(new Instruction("=", t, "", res));
        }
    }

    private String newTemp() {
        return "t" + tempCount++;
    }

    // Convierte infijo a postfijo (Shunting-yard simplificado)
    private String infixToPostfix(String expr) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]|[+\\-*/()]");
        Matcher matcher = pattern.matcher(expr);

        while (matcher.find()) {
            char token = matcher.group().charAt(0);
            if (Character.isLetterOrDigit(token)) {
                output.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token))
                    output.append(stack.pop());
                stack.push(token);
            }
        }

        while (!stack.isEmpty())
            output.append(stack.pop());

        return output.toString();
    }

    private int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
    }

    public String imprimir(codigoIntermedio ic) {
        return ic.toString();
    }
}
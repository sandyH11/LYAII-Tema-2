package com.sandysystems.menu.proyecto11;

import java.util.ArrayList;
import java.util.List;

public class codigoIntermedio {
    private final List<Instruction> inss = new ArrayList<>();

    public void add(Instruction i) { inss.add(i); }
    public List<Instruction> getInss() { return inss; }
    public void clear() { inss.clear(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        for (Instruction ins : inss) {
            sb.append(idx++).append(": ").append(ins).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static class Instruction {
        private final String op, arg1, arg2, res;

        public Instruction(String op, String arg1, String arg2, String res) {
            this.op = op; this.arg1 = arg1; this.arg2 = arg2; this.res = res;
        }

        @Override
        public String toString() {
            if (op.equals("="))
                return res + " = " + arg1;
            return res + " = " + arg1 + " " + op + " " + arg2;
        }
    }
}
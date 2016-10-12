package com.example;

/**
 * Created by dev on 10/11/16.
 */
public class ReversePolish {
    static String ADD = "+";
    static String SUB = "-";
    static String MUL = "*";
    static String DIV = "/";

    public Double calc(String args) {
        int index = 0;
        String[] params = args.split(" ");
        Double left = null;
        if (params.length >= 3) {
            while (index < params.length) {
                left = apply(left != null ? left : new Double(params[index++]), params[index++], params[index++]);
            }
        }
        return left;
    }

    private Double apply(Double dLeft, String right, String operator) {
        Double dRight = new Double(right);
        if (operator.equals(ADD)) return dLeft + dRight;
        else if (operator.equals(SUB)) return dLeft - dRight;
        else if (operator.equals(MUL)) return dLeft *  dRight;
        else if (operator.equals(DIV)) return dLeft / dRight;
        else return 0d;
    }
}

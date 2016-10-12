package com.example;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * Created by dev on 10/11/16.
 */
public class ReversePolish {
    static String ADD = "+";
    static String SUB = "-";
    static String MUL = "*";
    static String DIV = "/";

    Predicate<String> isNumeric = x->x.matches("[-+]?\\d*\\.?\\d+");

    public Double calc(String args) {
        String[] params = args.split(" ");
        Stack<String> stack=new Stack();
        Arrays.stream(params).forEach(x->process(stack, x));
        return new Double(stack.pop());
    }


    private void process(Stack<String> stack, String x) {
        if (!isNumeric.test(x) ) {
            String right = stack.pop();
            String left = stack.pop();
            stack.push(apply(new Double(left), new Double(right), x).toString());
        }else {
            stack.push(x);
        }

    }

    private Double apply(Double dLeft, Double dRight, String operator) {
        if (operator.equals(ADD)) return dLeft + dRight;
        else if (operator.equals(SUB)) return dLeft - dRight;
        else if (operator.equals(MUL)) return dLeft *  dRight;
        else if (operator.equals(DIV)) return dLeft / dRight;
        else return 0d;
    }
//
//     Function<List<String>, Double> apply1 = (List<String> operands) -> {
//        String operator=operands.get(2);
//        Double dLeft = new Double(operands.get(0));
//        Double dRight = new Double(operands.get(1));
//        return apply(dLeft, dRight, operator);
//    };

}

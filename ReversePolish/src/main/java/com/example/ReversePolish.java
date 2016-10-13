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

    public Double calcNonFunc(String args) {
        String[] params = args.split(" ");
        Stack<String> stack=new Stack();
        Arrays.stream(params).forEach(x->processNonFunc(stack, x));
        return new Double(stack.pop());
    }

    public Double calc(String args) {
        String[] params = args.split(" ");
        return  new Double(process(params[0],Arrays.copyOfRange(params,1, params.length)).pop());
    }

    private Stack<String> process(String left, String[] remainingParams) {
        Stack<String> stack = new Stack<String>();
        String result;
        if(remainingParams.length==1){
            stack.push(remainingParams[0]);
            stack.push(left);
            return stack;
        }
        if (!isNumeric.test(remainingParams[1])){
            result = apply(new Double(left), new Double(remainingParams[0]), remainingParams[1]).toString();
            if (remainingParams.length>2) {
                String[] temp =Arrays.copyOfRange(remainingParams,2,remainingParams.length);
                return process(result, temp);
            };
        }else{
            Stack<String> rightStack = process(remainingParams[0], Arrays.copyOfRange(remainingParams,1,remainingParams.length));
            result = apply(new Double(left), new Double(rightStack.pop()), rightStack.pop()).toString();
            if (!rightStack.empty()){
                return process(result, (String[])rightStack.toArray());
            }
        }
        stack.push(result);
        return stack;
    }

    private void processNonFunc(Stack<String> stack, String x) {
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

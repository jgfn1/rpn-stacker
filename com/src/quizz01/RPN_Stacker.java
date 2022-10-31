package com.src.quizz01;

import java.util.*;

class RPN_Stacker {
    public static int calculate(String expression) {
        if(expression.length() == 0) return 0;

        Stack stack = new Stack();

        boolean isOperand = false;
        int parsedNumber = 0;

        String[] splittedExpression = expression.split("\n");
        // System.out.println("splitted!");
        // System.out.println(splittedExpression[2]);
        for(int i = 0; i < splittedExpression.length; i++){
            // System.out.println("Read char:");
            // System.out.println(expression.charAt(i));
            try {
                parsedNumber = Integer.parseInt(splittedExpression[i]);
            }
            catch (NumberFormatException nfe) {
                isOperand = true;
            }
            if(!isOperand){
                stack.push(parsedNumber);
                // System.out.println("After push:");
                // System.out.println(Arrays.toString(stack.toArray()));
            }
            else{
                // System.out.println("Char is operator!");
                // System.out.println(Arrays.toString(stack.toArray()));
                int b = (int)stack.pop();
                int a = (int)stack.pop();
                switch(splittedExpression[i].charAt(0)){
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
                // System.out.println("After operation and push:");
                // System.out.println(Arrays.toString(stack.toArray()));
            }
            isOperand = false;
        }
        // System.out.println("oi: ");
        // System.out.println(Arrays.toString(stack.toArray()));
        return (int)stack.pop();
    }
}

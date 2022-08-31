package com.src;

import java.util.*;

class RPN_Stacker {
    public static int calculate(String expression) {
        if(expression.length() == 0) return 0;

        Stack stack = new Stack();

        boolean isOperand = false;
        int parsedNumber = 0;
        for(int i = 0; i < expression.length(); i++){
            // System.out.println("Read char:");
            // System.out.println(expression.charAt(i));
            try {
                parsedNumber = Integer.parseInt(expression.substring(i, i+1));
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
                switch(expression.charAt(i)){
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

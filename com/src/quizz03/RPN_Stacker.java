package com.src.quizz03;

import java.util.*;

class RPN_Stacker {
    public static int calculate(String expression) {
        if(expression.length() == 0) return 0;

        Stack stack = new Stack<Token>();
        
        String[] splittedExpression = expression.split("\n");
        // System.out.println("splitted!");
        // System.out.println(splittedExpression[2]);
        for(int i = 0; i < splittedExpression.length; i++){
            // System.out.println("Read char:");
            // System.out.println(expression.charAt(i));
            if(Regex.isNum(splittedExpression[i])){
                int parsedNumber = 0;
                parsedNumber = Integer.parseInt(splittedExpression[i]);
                Token parsedToken = new Token(TokenType.NUM, splittedExpression[i]);
                System.out.println(parsedToken.toString());
                stack.push(parsedNumber);
            }
            else if(Regex.isOP(splittedExpression[i])){
                // System.out.println("Char is operator!");
                // System.out.println(Arrays.toString(stack.toArray()));
                char operand = splittedExpression[i].charAt(0); 
                // System.out.println("operand: " + operand);
                switch(operand){
                    case '+': {
                        int b = (int)stack.pop();
                        int a = (int)stack.pop();
                        Token parsedToken = new Token(TokenType.PLUS, splittedExpression[i]);
                        System.out.println(parsedToken.toString());
                        stack.push(a + b);
                        break;
                    }
                    case '-': {
                        int b = (int)stack.pop();
                        int a = (int)stack.pop();
                        Token parsedToken = new Token(TokenType.MINUS, splittedExpression[i]);
                        System.out.println(parsedToken.toString());
                        stack.push(a - b);
                        break;
                    }
                    case '*': {
                        int b = (int)stack.pop();
                        int a = (int)stack.pop();
                        Token parsedToken = new Token(TokenType.STAR, splittedExpression[i]);
                        System.out.println(parsedToken.toString());
                        stack.push(a * b);
                        break;
                    }
                    case '/': {
                        int b = (int)stack.pop();
                        int a = (int)stack.pop();
                        Token parsedToken = new Token(TokenType.SLASH, splittedExpression[i]);
                        System.out.println(parsedToken.toString());
                        stack.push(a / b);
                        break;
                    }
                }
                // System.out.println("After operation and push:");
                // System.out.println(Arrays.toString(stack.toArray()));
            }
            else {
                throw new RuntimeException("Unexpected character: " + splittedExpression[i]);
            }
        }
        // System.out.println("oi: ");
        // System.out.println(Arrays.toString(stack.toArray()));
        return (int)stack.pop();
    }
}

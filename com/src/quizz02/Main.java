package com.src.quizz02;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        try{
            Path filePath = Path.of("com/src/quizz02/Calc1.stk");
            String content = Files.readString(filePath);
            // System.out.print("Result: ");
            // System.out.println(content);
            // content = content.replaceAll("\n", "");

            // System.out.print("Result: ");

            System.out.println(RPN_Stacker.calculate(content));
        }
        catch(Exception e){
            // System.out.println("Invalid expression!");
            System.out.println(e);
        }
    }
}
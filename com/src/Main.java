package com.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        try{
            Path filePath = Path.of("com/src/Calc1.stk");
            String content = Files.readString(filePath);
            content = content.replaceAll("\n", "");
            // System.out.println(content);

            System.out.print("Result: ");

            System.out.println(RPN_Stacker.calculate(content));
        }
        catch(Exception e){
            System.out.println("Invalid expression!");
            System.out.println(e);
        }
    }
}
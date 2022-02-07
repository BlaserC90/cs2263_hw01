//Simple left to right calculator program written for CS2263 @ISU Homework 1
package edu.isu.cs2263.hw02;

 /**
 * @author Chris Blaser
 **/

import java.util.Scanner;
import java.io.*;


/**
 * Class calc is a class that takes basic whole number input math expressions from the
 * command line and computes them from left to right ignoring order of operations
 *
 */
public class Calc{
    private String expression;
    private static double curValue;

    //implementing the interface method here to print out
    //@param expression: the mathmatical expression
    //@param ans the answer to the equation
    public void output(String expression, double ans){
        System.out.println(expression);
        System.out.println("  -> " + ans);
    }

    public void output(double ans){
        System.out.println("  -> " + ans);
    }

    public double getcurValue(){
        return curValue;
    }

    //method calc handles the calculating via by taking values from the String array
    //@param exp is expression after it has been split into an array
    //@returns currently value of expression
    public static double calculate(String[] exp){
        double a, b;
        curValue = 0;
        //Default
        if(exp.length == 1){
            return curValue = Double.parseDouble(exp[0]);
        }
        for(int i = 0; i < exp.length-2; i+=2){
            a = Double.parseDouble(exp[i]);
            b = Double.parseDouble(exp[i+2]);
            if(exp[i+1].equals("+")){
                curValue = a + b;
                exp[i+2] = String.valueOf(curValue);
            }
            else if(exp[i+1].equals("-")){
                curValue = a - b;
                exp[i+2] = String.valueOf(curValue);
            }
            else if(exp[i+1].equals("*")){
                curValue = a * b;
                exp[i+2] = String.valueOf(curValue);
            }
            else if(exp[i+1].equals("/")){
                curValue = a / b;
                exp[i+2] = String.valueOf(curValue);
            }

        }
        return curValue;
    }

    // method to read in input from the command line
    // @returns the input from the command line
    public String read(){
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();
        return expression;
    }

    //Input check,removes leading and ending spaces,looks for empty strings or letters in input
    //@param input: the input expression from the command line.
    //@return flag true passes the current checks for a satisfactory input
    public boolean check(String input){
        boolean flag;
        if(input.replaceAll(" ", "").isEmpty()){
            System.out.println("Please make sure to type an expression");
            flag = false;
            //the letter check.  Does not yet find all symbols
        }else if(input.matches(".*[a-zA-Z,.?<>;:!@#$%^&()_]+.*")){
            System.out.println("Expression must be a basic math equation.");
            flag = false;
        }else
            flag = true;
        return flag;
    }

    //Split the string by these delimiters and place in an array
    //@param expression is the equation given from the command line
    //@returns a string array with the components of the expression
    public String[] parse(String expression){
        return expression.split(" ");
    }
    //@param exp is the expression given from the terminal line
    //method combines everything together implementing the checks, parsing, and calculations
    public static void eval(String exp){
        Calc calc = new Calc();
        String[] dataArray = calc.parse(exp);
        calc.output(exp, calculate(dataArray));
    }

    //looping mechanism to keep asking for input and evaluating it
    public static void eval(){
        boolean flag = true;

        while(flag){
            Calc calc = new Calc();
            System.out.print("> ");
            String expression = calc.read();

            //input checks q for quiting
            if(expression.replaceAll(" ", "").equals("q") || expression.replaceAll(" ", "").equals("quit")){
                flag = false;
            //this checks for valid inputs
            }else if(!calc.check(expression)){
                flag = true;

            //if input passes previous checks, perform the parsing and print answer
            }else if(calc.check(expression)){
                String[] dataArray = calc.parse(expression);
                calc.output(calculate(dataArray));
                flag = true;
            }
        }
    }

    //@param takes the string path from the command line
    //method uses the command line argument to specify where to write out
    public static void evalOut(String path){
        boolean flag = true;

        while(flag){
            Calc calc = new Calc();
            System.out.print("> ");
            String expression = calc.read();

            //input checks q for quiting
            if(expression.replaceAll(" ", "").equals("q") || expression.replaceAll(" ", "").equals("quit")){
                System.exit(0);
                flag = false;

            //this checks for valid inputs
            }else if(!calc.check(expression)){
                flag = true;

            //if input passes previous checks, perform the parsing and print answer
            }else if(calc.check(expression)){
                String[] dataArray = calc.parse(expression);
                calc.output(calculate(dataArray));
                try{
                    File file = new File(path);
                    FileWriter writer = new FileWriter(path, true);
                        if(file.exists() && !file.isDirectory()){
                            writer.write(expression +"\n" + "  -> " + calc.getcurValue() + "\n");
                        }else{
                            file.createNewFile();
                            writer.write(expression + "\n" + "  -> " + calc.getcurValue() + "\n");
                            }
                    writer.close();
                    } catch (IOException e) {
                    e.printStackTrace();
                    }
            }
        }
    }
}


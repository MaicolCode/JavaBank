package org.example;

import java.util.Scanner;

public class Calculator {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Ingrese el primer número: ");
        double firstNum = scanner.nextDouble();
        System.out.println("Ingrese el segundo número: ");
        double secondNum = scanner.nextDouble();

        System.out.println("Elija la operacion que quiere realizar (+,-,/,*): ");
        String operator = scanner.next();

        double result;

        switch (operator) {
            case "+":
                result = add(firstNum, secondNum);
                break;
            case "-":
                result = substract(firstNum, secondNum);
                break;
            case "*":
                result = multiply(firstNum, secondNum);
                break;
            case "/":
                result = divide(firstNum, secondNum);
                break;
            default:
                throw new IllegalArgumentException("Operador no valido.");
        }

        System.out.println("El resultado obtenido es: "+result);
    }

    public double add(double firstNum, double secondNum){
        return firstNum + secondNum;
    }

    public double substract(double firstNum, double secondNum){
        return firstNum - secondNum;
    }

    public double multiply(double firstNum, double secondNum){
        return firstNum * secondNum;
    }

    public double divide(double firstNum, double secondNum){
        if(secondNum == 0){
            throw new ArithmeticException("Division por cero");
        }
        return firstNum / secondNum;
    }


}

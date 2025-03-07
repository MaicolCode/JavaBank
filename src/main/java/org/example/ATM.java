package org.example;

import java.util.Scanner;

public class ATM {
    private Calculator calculator = new Calculator();
    private int pin;
    private String accountNumber;
    private double balance;

    public ATM(int pin, String accountNumber, double balance){
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while(!exit) {
            System.out.println("-------------------------------");
            System.out.println("Bienvenido a JavaBank ATM.");
            System.out.println("Seleccione una operación:");
            System.out.println("1. Realizar una transacción");
            System.out.println("2. Usar la calculadora");
            System.out.println("0. Salir\n");

            System.out.print("Tu opcion:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int pin = this.pin;
                    BankAccount account1 = new BankAccount(this.accountNumber, this.balance);
                    AuthenticateUser user = new AuthenticateUser(pin);

                    if(user.authenticateUser("1234")){

                        account1.deposit(100);
                        account1.withdrawals(12);

                        System.out.println("---------Historial de movimientos en la cuenta-----------");
                        for(String result : account1.transactionHistory){
                            System.out.println(result);
                        }
                        System.out.println("---------------------------------------------------------");
                        account1.showBalance();

                    }
                    break;
                case 2:
                    calculator.start();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Gracias por usar JavaBank, que tengas un buen dia :)");
                    break;
                default:
                    throw new IllegalArgumentException("Option  no valida.");

            }
        }
        scanner.close();
    }
}

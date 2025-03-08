package org.example;

import java.util.Scanner;

public class ATM {
    private final Calculator calculator = new Calculator();
    private final int pin;
    private final String accountNumber;
    private double balance;
    private final Scanner scanner;  // Scanner único para toda la clase

    public ATM(int pin, String accountNumber, double balance) {
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.scanner = new Scanner(System.in); // Inicialización del scanner
    }

    public void start() {
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("Bienvenido a JavaBank ATM.");
            System.out.println("Seleccione una operación:");
            System.out.println("1. Realizar una transacción");
            System.out.println("2. Usar la calculadora");
            System.out.println("0. Salir\n");
            System.out.print("Tu opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    if (authenticateUser()) {
                        actionEventsAccount();
                    }
                    break;
                case 2:
                    calculator.start();
                    break;
                case 0:
                    System.out.println("Gracias por usar JavaBank, que tengas un buen día :)");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private boolean authenticateUser() {
        AuthenticateUser user = new AuthenticateUser(this.pin);
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Ingrese su PIN: ");
            String password = scanner.nextLine();

            if (user.authenticateUser(password)) {
                System.out.println("✅ Acceso concedido.");
                return true;
            } else {
                attempts++;
                System.out.println("❌ PIN incorrecto. Intento " + attempts + " de 3.");
            }
        }

        System.out.println("❌ Demasiados intentos fallidos. Regresando al menú.");
        return false;
    }

    private void actionEventsAccount() {
        BankAccount account = new BankAccount(accountNumber, balance);  // ✅ Única fuente de balance

        while (true) {
            System.out.println("----- Indica la acción que quieres realizar ------");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Estado de la cuenta");
            System.out.println("4. Cerrar");

            System.out.print("Acción a realizar: ");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double amountD = scanner.nextDouble();
                    account.deposit(amountD);  // ✅ Balance actualizado internamente
                    balance = account.showBalance();  // ✅ Sincronizar balance de ATM con BankAccount
                    System.out.println("✅ Depósito exitoso. Nuevo balance: " + balance + "$");
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double amountR = scanner.nextDouble();

                    if (amountR > account.showBalance()) {  // ✅ Validación de fondos
                        System.out.println("❌ Saldo insuficiente.");
                    } else {
                        account.withdrawals(amountR);
                        balance = account.showBalance();  // ✅ Sincronizar balance
                        System.out.println("✅ Retiro exitoso. Nuevo balance: " + balance + "$");
                    }
                    break;
                case 3:
                    System.out.println("📊 Estado de la cuenta: " + account.showBalance() + "$");
                    break;
                case 4:
                    System.out.println("🔒 Que tenga un buen día :3");
                    return;  // ✅ Salir del bucle
                default:
                    System.out.println("❌ La selección ingresada no existe.");
            }
        }
    }

}



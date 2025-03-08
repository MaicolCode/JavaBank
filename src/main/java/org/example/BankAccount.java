package org.example;

import java.util.ArrayList;

public class BankAccount {
    private String accountNumber;
    private double balance;
    ArrayList<String> transactionHistory = new ArrayList<>();

    // Creacion del constructor de la cuenta
    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Metodos a los que puede acceder la cuenta

    public void deposit(double amount){
        balance += amount;
        System.out.println("Nuevo deposito realizado. Balance actual: "+balance+"$");
        transactionHistory.add("Deposito de: "+amount);
    }

    public boolean withdrawals(double amount) {
        if(amount > balance) {
            System.out.println("Los fondos de tu cuenta son insuficientes!");
            return false;
        } else {
            balance -= amount;
            transactionHistory.add("Retiro de: "+amount);
            System.out.println("El retiro a sido exitoso. Balance actualizado: "+balance+"$");
            return true;
        }
    }

    public double showBalance() {
        return balance;
    }
}

package org.example;

public class BankAccount {
    private String accountNumber;
    private double balance;

    // Creacion del constructor de la cuenta
    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Metodos a los que puede acceder la cuenta

    public void deposit(double amount){
        balance += amount;
        System.out.println("Nuevo deposito realizado. Balance actual: "+balance+"$");
    }

    public boolean withdrawals(double amount) {
        if(amount > balance) {
            System.out.println("Los fondos de tu cuenta son insuficientes!");
            return false;
        } else {
            balance -= amount;
            System.out.println("El retiro a sido exitoso. Balance actualizado: "+balance+"$");
            return true;
        }
    }

    public void showBalance() {
        String state = (balance < 0)?"Deuda":"Credito";
        System.out.println("Actualmente tiene un balance de "+balance+"$");
        System.out.println("El estado de su cuenta es: "+state);
    }
}

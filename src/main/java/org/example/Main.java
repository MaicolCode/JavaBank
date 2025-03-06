package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456789", 5000.12);
        account1.showBalance();
        account1.deposit(100);
        account1.withdrawals(12);
    }
}
package org.example;

public class Main {
    private String pin;

    public static void main(String[] args) {


        int pin = 1234;

        AuthenticateUser user = new AuthenticateUser(pin);

        System.out.println(user.authenticateUser("1234"));



        BankAccount account1 = new BankAccount("123456789", 5000.12);
        account1.showBalance();
        account1.deposit(100);
        account1.withdrawals(12);

    }



}
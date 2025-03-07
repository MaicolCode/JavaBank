package org.example;

public class Main {
    private String pin;

    public static void main(String[] args) {
        ATM atm = new ATM(1234, "123456789",5000.00);

        atm.start();

    }



}
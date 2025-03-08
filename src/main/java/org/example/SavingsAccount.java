package org.example;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance,double interestRate ){
        super(accountNumber,balance );
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = showBalance()*interestRate;
        deposit(interest);
    }
}

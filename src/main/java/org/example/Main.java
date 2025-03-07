package org.example;

public class Main {
    private String pin;

    public static void main(String[] args) {
        int pin = 1234;
        BankAccount account1 = new BankAccount("123456789", 5000.12);
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


    }



}
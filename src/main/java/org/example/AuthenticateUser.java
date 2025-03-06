package org.example;

public class AuthenticateUser {
    int pin;

    public AuthenticateUser(int pin){
        this.pin = pin;
    }

    public boolean authenticateUser(String inputPin) {
        int attempts = 0;
        while(attempts < 3){
            if(this.pin == Integer.parseInt(inputPin)){
                return true;
            } else {
                attempts++;
                System.out.println("Pin incorrecto. Intento "+attempts+" de 3.");
            }
        }
        return false;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }
}

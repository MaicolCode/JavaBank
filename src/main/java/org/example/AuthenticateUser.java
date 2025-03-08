package org.example;

public class AuthenticateUser {
    int pin;

    public AuthenticateUser(int pin){
        this.pin = pin;
    }

    public boolean authenticateUser(String inputPin) {
        int attempts = 0;
        return this.pin == Integer.parseInt(inputPin);
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }
}

package com.company;

import java.util.Scanner;

public class Atm implements Hardware{
    Activity activity = new Activity();
    private int balance;
    Atm(){
        this.balance = 10000;
        System.out.println("\n Welcome to XXXX ATM!");
    }
    @Override
    public void screen(String msg) {
        switch (msg) {
            case "withdraw" -> this.cashDispenser();
            case "deposit" -> this.depositSlot();
            case "my balance" -> activity.viewMyBalance();
            case "change pin" -> {
                this.activity.sendOTP();
                if (this.activity.checkOTP(this.keypad())) {
                    System.out.print("Enter new PIN: ");
                    activity.changePIN(this.keypad());
                }
                else
                    System.out.println("Invalid OTP.");
            }
            case "transfer" -> {
                this.activity.sendOTP();
                if (this.activity.checkOTP(this.keypad())){
                    String an, ic, amt;
                    System.out.print("Enter recipient A/C: ");
                    an = this.keypad();
                    System.out.print("Enter recipient IFSC code: ");
                    ic = this.keypad();
                    System.out.print("Enter amount: ");
                    amt = this.keypad();
                    activity.transferFunds(an, ic, amt);
                }
                else
                    System.out.println("Invalid OTP.");
            }
            default -> System.out.println("Invalid Input.");
        }
    }

    @Override
    public String keypad() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    @Override
    public void cashDispenser() {
        System.out.print("Enter the amount: ");
        int amount = Integer.parseInt(this.keypad());
        if(amount <= this.balance) {
            activity.withdrawal(amount);
            this.balance -= amount;
        }
        else if (amount > 10000){
            System.out.println("Withdrawal limit exceeded.");
        }
        else{
            System.out.println("ATM is low in Cash!");
        }
    }

    @Override
    public void depositSlot() {
        System.out.print("Enter the amount: ");
        int amount = Integer.parseInt(this.keypad());
        activity.depositFunds(amount);
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        Atm atm = new Atm();
        String instructions = "'my balance' -> For viewing Balance.\n" +
                "'withdraw' -> For withdrawal.\n" +
                "'deposit' -> For deposit funds.\n" +
                "'change pin' -> For setting new PIN\n" +
                "'transfer' -> For transfer funds." +
                "'cancel' -> To cancel the transaction.";
        while (true){
            System.out.print("\nEnter Account Number: ");
            String accountNumber = atm.keypad();
            if (!atm.activity.isAccountExist(accountNumber))
                continue;
            System.out.print("Enter your PIN code: ");
            String PINCode = atm.keypad();
            if (!atm.activity.verifyPIN(PINCode))
                continue;
            System.out.println("\n Logged in Successfully!");
            System.out.println("\nUseful Instructions: ");
            System.out.println(instructions);
            System.out.print("\nPlease select one of the above to proceed: ");
            while(true){
                String action = atm.keypad();
                if (action.equals("cancel"))break;
                atm.screen(action);
            }
        }

    }
}

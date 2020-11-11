package com.company;

import java.util.Random;

public class Activity extends Accounts {

    private int index=0;
    private String OTP;
    public boolean isAccountExist(String accountNumber){
        if (accountNumber.length() < 5){
            System.out.println("ERROR: Account Number must be 5 character long.");
            return false;
        }
        for(int i=0;i<this.getAccountNumbers().size();++i){
            if (this.getAccountNumbers().get(i).equals(accountNumber)) {
                this.index = i;
                return true;
            }
        }
        System.out.println("Invalid Account Number.");
        return false;
    }

    public boolean verifyPIN(String PINCode){
        if (PINCode.length() != 5 ){
            System.out.println("ERROR: PIN Code must be 5 character long.");
            return false;
        }
        else if (this.getPIN().get(this.index).equals(PINCode))return true;
        System.out.println("Invalid PIN.");
        return false;
    }
    public String getDummyMN(){
        String mn = this.getMobileNo(this.index);
        return "XXXXXX" + mn.substring(5, 9);
    }
    public void sendOTP(){
        // Configuration need to be added to send OTP.
        this.generateOTP();
        System.out.print("Enter OTP sent on Registered Mobile No " + this.getDummyMN() + " : ");
        System.out.println(this.OTP);
    }
    public boolean checkOTP(String OTP){
        if (OTP.equals(this.OTP)){
            System.out.println("\n OTP has been verified.\n");
            return true;
        }
        return false;
    }
    public void transferFunds(String accountNo, String IFSCCode, String amount){
        if (Integer.parseInt(amount) <= this.getBalance().get(index)){
            System.out.println(" Transferred Successfully!");
            this.setWithdrawal(Integer.parseInt(amount), this.index);
        }
        else
            System.out.println("Insufficient Balance!");
    }
    public void viewMyBalance(){
        System.out.println(this.getBalance().get(this.index));
    }
    public void withdrawal(int amount){
        if (this.getBalance().get(this.index) >= amount){
            this.setWithdrawal(amount, this.index);
            System.out.println("withdrawal successful!");
        }
        else{
            System.out.println("Insufficient Funds!");
        }
    }
    public void depositFunds(int amount){
        if(amount > 0){
            this.setDeposits(amount, this.index);
            System.out.println("Amount Deposited!");
        }
        else{
            System.out.println("Invalid amount!");
        }
    }
    public void changePIN(String PINCode){
        if (PINCode.length() != 5) System.out.println("ERROR: PIN must be 5 characters long.");
        else{
            this.setPIN(PINCode, this.index);
            System.out.println(" PIN changed successfully!");
        }
    }
    private void generateOTP(){
        Random rand = new Random();
        int otp = rand.nextInt(9)*1234 + 1234;
        this.OTP = Integer.toString(otp);
    }
}

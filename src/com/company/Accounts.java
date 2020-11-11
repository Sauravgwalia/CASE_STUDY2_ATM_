package com.company;

import java.util.ArrayList;

public class Accounts {
    private final ArrayList<Integer> balance = new ArrayList<>();
    private final ArrayList<String> accountNumbers = new ArrayList<>();
    private final ArrayList<String> PIN = new ArrayList<>();
    private final ArrayList<String> MobileNo = new ArrayList<>();

    Accounts(){
        for(int i=0;i<4;++i)this.balance.add(10000);
        this.accountNumbers.add("12345");
        this.accountNumbers.add("23456");
        this.accountNumbers.add("34567");
        this.PIN.add("12345");
        this.PIN.add("23456");
        this.PIN.add("34567");
        this.MobileNo.add("123456790");
        this.MobileNo.add("234567901");
        this.MobileNo.add("345679012");
    }

    public ArrayList<Integer> getBalance() {
        return this.balance;
    }

    public ArrayList<String> getAccountNumbers() {
        return this.accountNumbers;
    }

    public ArrayList<String> getPIN() {
        return this.PIN;
    }
    public void setWithdrawal(int amount, int index){
        int amt = this.balance.get(index);
        this.balance.remove(index);
        this.balance.add(index, amt-amount);
    }
    public void setDeposits(int amount, int index){
        int amt = this.balance.get(index);
        this.balance.remove(index);
        this.balance.add(index, amt+amount);
    }
    public void setPIN(String PINCode, int index){
        String pin = this.PIN.get(index);
        this.PIN.remove(index);
        this.PIN.add(index, PINCode);
    }
    public String getMobileNo(int index){
        return this.MobileNo.get(index);
    }
}

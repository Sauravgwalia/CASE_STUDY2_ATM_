> # CASE STUDY 2 ATM

A programm for operation of ATM.

### It has one interface
* Hardware : It has following methods
    * screen - It displays the output on screen.
    * keyPad - Enables keyboard for taking input from keyboard.
    * cashDishpenser - Opens cash dishpenser at the time of withdrawal.
    * depositSlot - Opens deposit slot while depositing Cash.

### It consists following classes:
* #### Accounts
    * This class consists data of all customers.
    * It also takes care of editing balance and modifying PIN.
* #### Activity
    * This class inherite Accounts class and takes care of all transactions.
    * It has following method:
        * isAccountExist - Verifies whether an account No. is there in data or not.
        * verifyPIN - Verifies enterd PIN code.
        * viewMyBalance - Shows account balance.
        * depositFunds - Takes care of funds deposit.
        * withdrawal - Takes care of fund withdrawals.
        * changePIN - Deals with changing PIN of respective account.

* #### Atm
    * This class implements the Hardware.
    * And also it inherits Activity class.
    * Proceeds through every query of user. 

* #### Main
    * This class creates an Atm object.
    * And uses Atm to deal with users query.

 > ## In database of this ATM 3 users are added.
* USER 1:
    * Account No. - 12345
    * PIN Code - 12345
* USER 2:
    * Account No. - 23456
    * PIN Code - 23456
* USER 3:
    * Account No. - 34567
    * PIN Code - 34567

> ### Preview

    Welcome to XXXX ATM!

    Enter Account Number: 12345
    Enter PIN Code: 12345

    Logged in Successfully!

    Useful Instructions: 
        my balance - For viewing Balance.
        withdraw - For withdrawal.
        deposit - For deposit funds
        change pin - For setting new PIN
        cancel - To cancel the transaction.

    Please select one of the above: my balance
    10000
    withdraw
    Enter the amount: 500
    Withdrawal successful!
    cancel
> ### Exited

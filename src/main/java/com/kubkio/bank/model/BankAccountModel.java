package com.kubkio.bank.model;

import com.kubkio.bank.entity.BankAccountEntity;

public class BankAccountModel {
    static int acNumSeed=1000;
    private long id;
    static long routingNumber;
    private long accountNumber;
    private double amount;
    private AccountType accountType;

    private String accountSSN;

    private String message;

//    public BankAccountModel(String accountSSN, AccountType accountType) {
//        this.accountNumber= acNumSeed++;
//        this.routingNumber= System.currentTimeMillis();
//        this.amount=0;
//        this.accountSSN = accountSSN;
//        this.accountType= accountType;
//
//    }

    public BankAccountModel() {
        //this.accountNumber= acNumSeed++ ;
        this.accountNumber= System.currentTimeMillis();
        this.routingNumber=9898;
        this.amount=25;
    }

    public BankAccountModel(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountSSN() {
        return accountSSN;
    }

    public void setAccountSSN(String accountSSN) {
        this.accountSSN = accountSSN;
    }

    @Override
    public String toString() {
        return "BankAccountModel{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", accountType=" + accountType +
                ", accountSSN='" + accountSSN + '\'' +
                '}';
    }
}

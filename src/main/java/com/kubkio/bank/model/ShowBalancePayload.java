package com.kubkio.bank.model;

public class ShowBalancePayload {
    long accountNumber;
    AccountType accountType;
    long amount;

    String msg;

    public ShowBalancePayload(String msg) {
        this.msg = msg;
    }

    public ShowBalancePayload() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

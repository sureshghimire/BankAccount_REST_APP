package com.kubkio.bank.entity;

import com.kubkio.bank.model.AccountType;

import javax.persistence.*;

@Entity(name = "bank_accounts")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long routingNumber;

    @Column
    private long accountNumber;

    @Column
    private double amount;

    @Column

    private String accountType;

    @Column(name = "ssn")
    private String accountSSN;

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountSSN() {
        return accountSSN;
    }

    public void setAccountSSN(String accountSSN) {
        this.accountSSN = accountSSN;
    }
}

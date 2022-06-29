package com.kubkio.bank.service;

import com.kubkio.bank.model.*;

public interface BankAccountServiceIf {

    //create bank account using existing profile
    public BankAccountModel createBankAc(CreateAcPayload createAcPayload);

    public ShowBalancePayload viewBalance(ReqViewBalancePayload reqViewBalancePayload);

    public ShowBalancePayload withdraw(ReqWithDrawPayload reqWithDrawPayload);






}

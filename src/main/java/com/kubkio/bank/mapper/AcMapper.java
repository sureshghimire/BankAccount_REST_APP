package com.kubkio.bank.mapper;

import com.kubkio.bank.entity.BankAccountEntity;
import com.kubkio.bank.model.AccountType;
import com.kubkio.bank.model.BankAccountModel;

public class AcMapper {

    public static BankAccountEntity accountMap(BankAccountModel acModel){
        BankAccountEntity en = new BankAccountEntity();
        en.setAccountNumber(acModel.getAccountNumber());
        en.setRoutingNumber(acModel.getRoutingNumber());
        en.setAmount(acModel.getAmount());
        en.setAccountType(acModel.getAccountType().toString());
        en.setAccountSSN(acModel.getAccountSSN());
        return en;
    }

    public static BankAccountModel accountMap(BankAccountEntity en){
        BankAccountModel md = new BankAccountModel();
        md.setId(en.getId());
        md.setAccountSSN(en.getAccountSSN());
        md.setAccountNumber(en.getAccountNumber());
        md.setRoutingNumber(en.getRoutingNumber());

        // Need to cast en.getAccoutType()-String to AccountType
        //md.setAccountType(en.getAccountType());

        md.setAmount(en.getAmount());
        return md;
    }
}

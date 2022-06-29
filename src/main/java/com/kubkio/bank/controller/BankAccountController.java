package com.kubkio.bank.controller;

import com.kubkio.bank.model.*;
import com.kubkio.bank.service.BankAcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @Autowired
    BankAcService service;

    @RequestMapping(value = "/createBankAc", method = RequestMethod.POST)
    public BankAccountModel signUpBankAc(@RequestBody CreateAcPayload ssn_acType){
        return service.createBankAc(ssn_acType);
    }

    @RequestMapping(value = "/viewBalance",method = RequestMethod.POST)
    public ShowBalancePayload viewAvailableBalance(@RequestBody ReqViewBalancePayload payload){
        return service.viewBalance(payload);
    }

    @RequestMapping(value = "/withdrawAmount", method = RequestMethod.POST)
    public ShowBalancePayload withdrawBalance(@RequestBody ReqWithDrawPayload payload){
        return  service.withdraw(payload);
    }

}

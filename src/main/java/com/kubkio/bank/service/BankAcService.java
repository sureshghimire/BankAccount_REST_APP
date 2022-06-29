package com.kubkio.bank.service;

import com.kubkio.bank.doa.BankAccountDao;
import com.kubkio.bank.entity.BankAccountEntity;
import com.kubkio.bank.mapper.AcMapper;
import com.kubkio.bank.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BankAcService implements BankAccountServiceIf{


    Logger logger = LoggerFactory.getLogger(this.getClass());



   @Autowired
   BankAccountDao acDao;

   private RestTemplate restTemplate =new RestTemplate();


   private boolean checkAcExists(String ssn){

       logger.info("Checking whether ssn exists");
       String getAccBySsnUrl = "http://localhost:8080/bank/view?ssn=" + ssn;
        logger.info("External Service SSN Url -> " + getAccBySsnUrl);
       ResponseEntity<String> resxonse = restTemplate.getForEntity(getAccBySsnUrl, String.class);
       logger.info("Response received: " + resxonse.getBody());
       logger.info("Status Code: " + resxonse.getStatusCode());
       return resxonse.getBody() != null;

   }



    @Override
    public BankAccountModel createBankAc(CreateAcPayload payload){

       if(!(checkAcExists(payload.getSsn()))){
           return new BankAccountModel("Account with ssn "+payload.getSsn()+" does not exists");
       }else {
           BankAccountModel model2save = new BankAccountModel();
           model2save.setAccountSSN(payload.getSsn());
           model2save.setAccountType(payload.getAccountType());

           //Map to entity
           BankAccountEntity entity2save = AcMapper.accountMap(model2save);
           acDao.makeNewAcc(entity2save);

           //Map saved entity to model. So the return response will be bank model
           BankAccountModel model2return = AcMapper.accountMap(entity2save);
           return model2return;
       }

    }

    @Override
    public ShowBalancePayload viewBalance(ReqViewBalancePayload payload) {
        if(!(checkAcExists(payload.getSsn()))){
            return new ShowBalancePayload("Account with ssn "+payload.getSsn()+" does not exists");
        }{
            ShowBalancePayload show = new ShowBalancePayload();

            // TODO: get account number from the existing table that match the passed ssn
            // acDao
            long acNum = acDao.getAccountNumber(payload.getSsn());
            show.setAccountNumber(acNum);
            show.setAccountType(payload.getAccountType());
            show.setAmount(acDao.getAvailableBalance(payload.getSsn()));

            return show;
        }

    }

    @Override
    public ShowBalancePayload withdraw(ReqWithDrawPayload reqWithDrawPayload) {

       // TODO: Account number validation
        BankAccountEntity existingAccount = acDao.getAccount(reqWithDrawPayload.getAccountNumber());
        double availableBalance = existingAccount.getAmount();
        double netBalanceAfterWithdraw = availableBalance - reqWithDrawPayload.getWithdrawAmount();
        existingAccount.setAmount(netBalanceAfterWithdraw);
        existingAccount = acDao.saveOrUpdate(existingAccount);

        ShowBalancePayload showBalancePayload = new ShowBalancePayload();
        showBalancePayload.setAmount((long) existingAccount.getAmount());
        return  showBalancePayload;
    }

}

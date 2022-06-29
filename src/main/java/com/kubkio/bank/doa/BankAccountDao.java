package com.kubkio.bank.doa;

import com.kubkio.bank.entity.BankAccountEntity;
import com.kubkio.bank.model.BankAccountModel;
import com.kubkio.bank.repo.BankAccountRepo;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BankAccountDao {

    @Autowired
    BankAccountRepo accountRepo;

    public BankAccountEntity makeNewAcc(BankAccountEntity bankAccountEntity){
        return accountRepo.save(bankAccountEntity);
    }

    public long getAccountNumber(String ssn) {
        long acNum = accountRepo.getAccountNum(ssn);
        return acNum;
    }

    public long getAvailableBalance(String ssn) {
        long amount = accountRepo.getAmount(ssn);
        return  amount;
    }

    public long getAvailableBalanceByAcNum(long accountNumber) {
        return accountRepo.getAmountByAcNum(accountNumber);
    }

    public void updateBankAcc(long accountNumber, BankAccountModel model) {
        // TODO: Work on it save on account repo


    }

    public BankAccountEntity saveOrUpdate(BankAccountEntity entity) {
        return accountRepo.save(entity);
    }

    public BankAccountEntity getAccount(long accountNumber) {

        return accountRepo.findByAccountNum(accountNumber);

    }
}

package com.kubkio.bank.repo;

import com.kubkio.bank.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccountEntity, Long> {


    @Query(value = "select account_number from bank_accounts where ssn=?1",nativeQuery = true)
        public Long getAccountNum(String ssn);

    @Query(value = "select amount from bank_accounts where ssn=?1",nativeQuery = true)
    long getAmount(String ssn);

    @Query(value = "select amount from bank_accounts where account_number=?1",nativeQuery = true)
    long getAmountByAcNum(long accountNumber);

    @Query(value = "select ba from bank_accounts ba where ba.account_number=?1",nativeQuery = true)
    BankAccountEntity findByAccountNum(long accountNumber);

}

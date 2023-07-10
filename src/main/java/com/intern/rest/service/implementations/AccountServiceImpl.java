package com.intern.rest.service.implementations;

import com.intern.rest.constant.Status;
import com.intern.rest.entity.Account;
import com.intern.rest.model.account.NewAccountRequest;
import com.intern.rest.model.account.UpdateAccountRequest;
import com.intern.rest.repository.AccountRepository;
import com.intern.rest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        List<Account> accountList = accountRepository.findAll();

        return accountList;
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);

        return account;
    }

    @Override
    public String save(NewAccountRequest newAccount) {
        Account temporaryAccount = new Account();

        temporaryAccount.setAccountNumber(this.generateTenDigitsAccountNumber());
        temporaryAccount.setType(newAccount.getType());
        temporaryAccount.setStatus(Status.ACTIVE);
        temporaryAccount.setOpeningDate(new Date());
        temporaryAccount.setBalance(newAccount.getBalance());

        accountRepository.save(temporaryAccount);

        return temporaryAccount.getAccountNumber();
    }

    @Override
    public Boolean update(String accountNumber,UpdateAccountRequest updateAccount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        if(updateAccount.getStatus()!=null)
        {
            account.setStatus(updateAccount.getStatus());
        }

        if(account.getStatus() != Status.CLOSED)
        {
            if(updateAccount.getBalance() != null)
            {
                account.setBalance(updateAccount.getBalance());
                accountRepository.save(account);
                return true;
            }

            accountRepository.save(account);
            return true;
        }

        accountRepository.save(account);

        return false;
    }

    @Override
    public void delete(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        accountRepository.delete(account);
    }

    private String generateTenDigitsAccountNumber() {
        String tenDigitsString = "";

        for(int i=0; i<10;i++)
        {
            Random randomNumber = new Random();
            int oneDigit = randomNumber.nextInt(9);
            tenDigitsString += Integer.toString(oneDigit);

        }

        return tenDigitsString;
    }

}

package com.intern.rest.controller;

import com.intern.rest.entity.Account;
import com.intern.rest.model.account.NewAccountRequest;
import com.intern.rest.model.account.UpdateAccountRequest;
import com.intern.rest.service.AccountService;
import com.intern.rest.service.implementations.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private AccountService accountService;
    @Autowired
    AccountController(AccountServiceImpl accountService)
    {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts()
    {
        List<Account> accountList = accountService.findAll();

        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable(value = "accountNumber") String accountNumber)
    {
        Account account = accountService.findByAccountNumber(accountNumber);

        return new ResponseEntity<Account>(account,HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<String> createNewAccount(@RequestBody NewAccountRequest newAccountRequest)
    {
        String accountNumber = accountService.save(newAccountRequest);

        return new ResponseEntity<String>("You Created New Account With Account Number : "+accountNumber+" .",
                HttpStatus.OK);
    }

    @PutMapping("/accounts/{accountNumber}")
    public ResponseEntity<String> updateExistingAccount(@PathVariable(value = "accountNumber") String accountNumber
    , @RequestBody UpdateAccountRequest updateAccountRequest)
    {
        if(accountService.update(accountNumber,updateAccountRequest))
        {
            return new ResponseEntity<String>("You Updated For Account Number : "+accountNumber+".",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Sorry, You Can't Update Balance."+accountNumber + " Had Been Closed.",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/accounts/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable(value = "accountNumber") String accountNumber)
    {
        accountService.delete(accountNumber);

        return new ResponseEntity<String>("You Deleted Account Number : "+accountNumber+".",HttpStatus.OK);
    }
}

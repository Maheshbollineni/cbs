package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService service;
    @PostMapping("/openAC")
    public Account add(@RequestBody Account acc){
        return service.add(acc);
    }

    @PostMapping("/getBalance")
    public double getbal(@RequestBody long accno){
        return service.getBalance(accno);
    }

    @DeleteMapping("/close")
    public void delete(@RequestBody Long accno){
        service.delete(accno);
    }

    @PatchMapping("/deposit")
    public String deposit(@RequestBody Transactions tx){
        return service.deposit(tx.accno, (float) tx.amt);
    }

    @PatchMapping("/withdraw")
    public String withdraw(@RequestBody Transactions tx){
        return service.withdraw(tx.accno, (float) tx.amt);
    }

}

class Transactions{
    long accno;
    double amt;
}
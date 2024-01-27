package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.service.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService service;
    @PostMapping("/openAC")
    public String add(@RequestBody Account acc){
        service.add(acc);
        return "Account created successfully :"+acc.getAccountno();
    }

    @PostMapping("/getBalance")
    public double getbal(@RequestBody Long accno){
        return service.getBalance(accno);
    }

    @DeleteMapping("/close")
    public String delete(@RequestBody Long accno){

        return service.delete(accno);
    }

    @PatchMapping("/deposit")
    public String deposit(@RequestBody Transactions tx){
        return service.deposit(tx.getAccno(), (float) tx.getAmt());
    }

    @PatchMapping("/withdraw")
    public String withdraw(@RequestBody Transactions tx){
        return service.withdraw(tx.getAccno(), (float) tx.getAmt());
    }

    @PostMapping("/getAccount")
    public Account getAc(@RequestBody Long accno)
    {return service.getAc(accno);}
}


class Transactions{
    @Getter
    @Setter
    private long accno;
    @Getter @Setter private double amt;
}
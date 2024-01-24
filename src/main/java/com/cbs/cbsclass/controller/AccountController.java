package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    AccountService service;
    @PostMapping("/openAC")
    public Account add(@RequestBody Account acc){
        return service.add(acc);
    }

    @GetMapping("/getBalance")
    public double getbal(@RequestBody String cid){
        return service.getBalance(cid);
    }

    @DeleteMapping("/close")
    public void delete(@RequestBody String id){
        service.delete(id);
    }

    @PatchMapping("/deposit")
    public String deposit(@RequestBody Transactions tx){
        return service.deposit(tx.accno,tx.amt);
    }

    @PatchMapping("/withdraw")
    public String withdraw(@RequestBody Transactions tx){
        return service.withdraw(tx.accno,tx.amt);
    }

}

class Transactions{
    String accno;
    double amt;
}
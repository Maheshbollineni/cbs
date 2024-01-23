package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.service.AccountService;
import com.cbs.cbsclass.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    AccountService service;
    @PostMapping("/openAC")
    public Account add(@RequestBody Account acc){
        return service.add(acc);
    }

    @GetMapping("/getBalance")
    public double getbal(@RequestParam String cid){
        return service.getBalance(cid);
    }

    @DeleteMapping("/close")
    public void delete(@RequestParam String id){
        service.delete(id);
    }

    @PatchMapping("/deposit")
    public String deposit(@RequestParam String accno,@RequestParam double amt){
        return service.deposit(accno,amt);
    }

    @PatchMapping("/withdraw")
    public String withdraw(@RequestParam String accno,@RequestParam double amt){
        return service.withdraw(accno,amt);
    }

}

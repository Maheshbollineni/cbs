package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.service.AccountService;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping("/")
    public void display(){
        System.out.println("inside display");
    }
    @PostMapping("/openAC")
    public String add(@RequestBody Account acc){
        service.add(acc);
        return new Gson().toJson("Account created successfully :"+acc.getAccountno());
    }

    @PostMapping("/getBalance")
    public String getbal(@RequestBody Long accno){
        return new Gson().toJson(service.getBalance(accno));
    }

    @DeleteMapping("/close")
    public String delete(@RequestBody Long accno){
        return new Gson().toJson(service.delete(accno));
    }

    @PatchMapping("/deposit")
    public String deposit(@RequestBody Transactions tx)
    {
        return new Gson().toJson(service.deposit(tx.getAccno(), (float) tx.getAmt()));
    }

    @PatchMapping("/withdraw")
    public String withdraw(@RequestBody Transactions tx){
        return new Gson().toJson(service.withdraw(tx.getAccno(), (float) tx.getAmt()));
    }

    @PostMapping("/getAccount")
    public String getAc(@RequestBody Customer c)
    {
        List<Account>as=service.getAc(c.getCustid());
        List<Long> al=new ArrayList<>();
        for(Account a:as){
            al.add(a.getAccountno());
        }
        return new Gson().toJson(al);}
}


class Transactions{
    @Getter
    @Setter
    private long accno;
    @Getter @Setter private double amt;
}
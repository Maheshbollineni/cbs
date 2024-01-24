package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.service.AccountService;
import com.cbs.cbsclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    AccountService as;

    @PostMapping("/register")
    public String add(@RequestBody Register r){

        Customer c=service.register(r.customer);
        if(c!=null)
            as.add(r.account);
        return "Registered Successfully "+c.getCustid()+" "+r.account.getAccountno();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Rbody rb){
        return service.authenticate(rb.cid,rb.password);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String id){
         service.delete(id);
    }
}


class Rbody{
    String cid;
    String password;
}

class Register{
    Customer customer;
    Account account;
}
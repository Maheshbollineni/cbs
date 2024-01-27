package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.service.AccountService;
import com.cbs.cbsclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public String add(@RequestBody Customer c){
        service.register(c);
        return "Registered Successfully "+c.getCustid();
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer c){
        boolean b= service.authenticate(c);
        if(b){
            return "Login Successful";
        }
        return "Error!Check your customer id and password";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String cid){
         return service.delete(cid);
    }
}


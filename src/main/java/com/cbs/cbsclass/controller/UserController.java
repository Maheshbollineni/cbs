package com.cbs.cbsclass.controller;


import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    CustomerService service;
    @PostMapping("/register")
    public Customer add(@RequestBody Customer cust){
        return service.register(cust);
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String cid, @RequestParam String passowrd){
        return service.authenticate(cid,passowrd);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String id){
         service.delete(id);
    }


}

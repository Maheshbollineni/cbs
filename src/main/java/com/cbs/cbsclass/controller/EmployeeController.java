package com.cbs.cbsclass.controller;
import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.dao.Employee;
import com.cbs.cbsclass.service.AccountService;
import com.cbs.cbsclass.service.EmployeeService;
import com.cbs.cbsclass.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class EmployeeController {
        @Autowired
        EmployeeService service;

//        @PostMapping("/regi")
//        public Employee add(@RequestBody Employee e){
//
//            return service.register(e);
//        }

        @PostMapping("/loginemp")
        public String login(@RequestBody Employee emp){
            return new Gson().toJson(service.authenticate(emp));
        }

        @DeleteMapping("/deleteemp")
        public void delete(@RequestParam int eid){
            service.delete(eid);
        }

        @PutMapping("/performTransaction")
        public  Transactions debitorcredit(){
            return new Transactions();
        }
    }



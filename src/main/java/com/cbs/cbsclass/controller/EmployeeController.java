package com.cbs.cbsclass.controller;
import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.dao.Employee;
import com.cbs.cbsclass.service.AccountService;
import com.cbs.cbsclass.service.EmployeeService;
import com.cbs.cbsclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {
        @Autowired
        EmployeeService service;

        @PostMapping("/register")
        public Employee add(@RequestBody Employee e){

            return service.register(e);
        }

        @PostMapping("/login")
        public boolean login(@RequestBody Rbody1 rb){
            return service.authenticate(rb.empid,rb.password);
        }

        @DeleteMapping("/delete")
        public void delete(@RequestParam int eid){
            service.delete(eid);
        }

        @PutMapping("/performTransaction")
        public  Transactions debitorcredit(){
            return new Transactions();
        }
    }



class Rbody1{
    int empid;
    String password;
}
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
        @GetMapping("/emp")
        public Employee display(){
            return new Employee();
        }
        @PostMapping("/empregister")
        public String register(@RequestBody Employee emp){
            emp = service.register(emp);
            if (emp == null) return "Employee ID already registered";
            return "Registered Successful";
//            return new Gson().toJson(emp);
        }

        @PostMapping("/emplogin")
        public String login(@RequestBody Employee emp){
            boolean bool = service.authenticate(emp);
            if(bool){
                return new Gson().toJson("Login Successful");
            }
            return new Gson().toJson("Error!Check your customer id and password");
        }

        @DeleteMapping("/empdlete")
        public void delete(@RequestBody int empid){
            service.delete(empid);
        }

        @PutMapping("/performTransaction")
        public  Transactions debitorcredit(){
            return new Transactions();
        }
    }



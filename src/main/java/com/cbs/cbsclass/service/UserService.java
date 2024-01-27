package com.cbs.cbsclass.service;


import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer register(Customer c){

        if(customerRepo.findByCustid(c.getCustid())!=null){
            return null;
        }
        c.setIsactive(true);
        c.setCreatedat(LocalDateTime.now());
        c.setCreatedby(c.getFirstname());
        return customerRepo.save(c);
    }

    public boolean authenticate(Customer c){
        Customer c1=customerRepo.findByCustid(c.getCustid());
        if(c1!=null&&c1.getPassword().equals(c.getPassword()))
                return true;
        return false;
    }

    public String delete(String custid){
        try {
            Customer c = customerRepo.findByCustid(custid);
            customerRepo.deleteById(c.getId());
            return "Success";
        }
        catch(Exception e){
            return "Failed to delete";
        }
    }



}

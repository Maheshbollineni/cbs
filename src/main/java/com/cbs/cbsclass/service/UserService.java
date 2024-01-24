package com.cbs.cbsclass.service;


import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer register(Customer c){
        if(customerRepo.findByCustid(c.getCustid())!=null){
            return null;
        }
        c.setDate(new Date());
        c.setIsactive(true);

        return customerRepo.save(c);
    }

    public boolean authenticate(String custid,String password){
        Customer c=customerRepo.findByCustid(custid);
        if(c!=null&&c.getPassword().equals(password))
                return true;
        return false;
    }

    public void delete(String custid){
        Customer c=customerRepo.findByCustid(custid);
        customerRepo.deleteById(c.getId());
    }



}

package com.cbs.cbsclass.service;


import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.repository.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepo customerRepo;

    public Customer register(Customer c){
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

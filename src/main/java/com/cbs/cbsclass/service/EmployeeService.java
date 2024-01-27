package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.dao.Employee;
import com.cbs.cbsclass.repository.CustomerRepo;
import com.cbs.cbsclass.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepo repo;

    public Employee register(Employee e){
        if(repo.findByEmpid(e.getEmpid())!=null){
            return null;
        }
        e.setIsactive(true);
        return repo.save(e);
    }

    public boolean authenticate(Employee emp){
        Employee e=repo.findByEmpid(emp.getEmpid());
        if(e!=null&&e.getPassword().equals(emp.getPassword()))
            return true;
        return false;
    }

    public void delete(int eid){
        Employee e=repo.findByEmpid(eid);
        repo.deleteById(e.getId());
    }


}

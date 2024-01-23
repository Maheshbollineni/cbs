package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.CustomerRepo;
import org.springframework.stereotype.Service;

public class AccountService {

AccountRepo repo;

        public Account add(Account a){
            return repo.save(a);
        }

        public double getBalance(String accno){
            Account ac= repo.getAccountbyAccID(accno);
            return ac.getBalance();
        }
        public void delete(String accno){
            repo.deleteById(repo.getAccountbyAccID(accno).getId());
        }

        public String deposit(String accno,double amt){
            Account ac=repo.getAccountbyAccID(accno);
            double oldbal=ac.getBalance();
            ac.setBalance(oldbal+amt);
            repo.save(ac);
            return "A/C Balance: "+ac.getBalance();
        }

        public String withdraw(String accno,double amt){
        Account ac=repo.getAccountbyAccID(accno);
        double oldbal=ac.getBalance();
        ac.setBalance(oldbal-amt);
        repo.save(ac);
        return "A/C Balance: "+ac.getBalance();
    }
    }



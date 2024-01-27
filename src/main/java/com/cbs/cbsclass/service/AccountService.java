package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountService {

    @Autowired
AccountRepo repo;

        public Account add(Account a){
            Random random = new Random();
            long randomNumber = random.nextLong() % 10000000000000000L;
            a.setAccountno(Math.abs(randomNumber));
            return repo.save(a);
        }
        public double getBalance(long accno){
            Account ac= repo.findByAccountno(accno);
            return ac.getBalance();
        }
        public String delete(long accno){
            repo.deleteById(repo.findByAccountno(accno).getId());
            return "Account closed";
        }

        public String deposit(long accno,float amt){
            Account ac=repo.findByAccountno(accno);
            float oldbal=ac.getBalance();
            ac.setBalance((float) (oldbal+amt));
            repo.save(ac);
            return "A/C Balance: "+ac.getBalance();
        }

        public String withdraw(long accno,float amt){
        Account ac=repo.findByAccountno(accno);
        float oldbal=ac.getBalance();
        ac.setBalance(oldbal-amt);
        repo.save(ac);
        return "A/C Balance: "+ac.getBalance();
    }

    public Account getAc(long accno){
            return repo.findByAccountno(accno);
    }
    }



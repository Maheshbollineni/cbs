package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.CustomerRepo;
import com.cbs.cbsclass.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
AccountRepo repo;
    @Autowired
    InterestCalculationService ias;


        public Account add(Account a){
            Random random = new Random();
            long randomNumber = random.nextLong() % 10000000000000000L;
            a.setAccountno(Math.abs(randomNumber));
            a.setIsActive(true);
            return repo.save(a);
        }
        public double getBalance(long accno){
            Account ac= repo.findByAccountno(accno);
            return ac.getBalance();
        }
        public String delete(long accno){
            Account ac=repo.findByAccountno(repo.findByAccountno(accno).getId());
            ias.calcInterestForAccountClosure(ac);
            ac.setIsActive(false);
            repo.save(ac);
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

    public List<Account> getAc(String custid) {
        System.out.println("in service getAc() for custid: "+custid);
         return repo.findByCustid(custid);
    }
}



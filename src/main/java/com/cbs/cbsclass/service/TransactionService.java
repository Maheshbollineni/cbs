package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionsRepository tr;
    @Autowired
    AccountRepo ar;

    public Transaction add(Transaction t){
        return tr.save(t);
    }
    public List<Transaction> getHistory(long accountno){
        return tr.findByAccountno(accountno);
    }

    public Transaction sendMoney(long accountno_r,long accountno_s,float amount) {

        Transaction ntr=new Transaction();
        Account rec = ar.findByAccountno(accountno_r);
        Account sd = ar.findByAccountno(accountno_s);
        if (rec == null){
            ntr.setAccountno(accountno_s);
            ntr.setAmount(amount);
            ntr.setTx_from(accountno_s);
            ntr.setTx_to(accountno_r);
            ntr.setBalance(sd.getBalance());
            ntr.setTx_status("Failed,Incorrect Account Number");
            return add(ntr);
        }
        if(sd.getBalance() < amount){
            ntr.setAccountno(accountno_s);
            ntr.setAmount(amount);
            ntr.setTx_from(accountno_s);
            ntr.setTx_to(accountno_r);
            ntr.setBalance(sd.getBalance());
            ntr.setTx_status("Failed,Insufficent Balance");
            return add(ntr);
        }
        sd.setBalance(sd.getBalance() - amount);
        rec.setBalance(rec.getBalance() + amount);
        ar.save(sd);
        ar.save(rec);

        ntr.setAccountno(accountno_s);
        ntr.setAmount(amount);
        ntr.setTx_from(accountno_s);
        ntr.setTx_to(accountno_r);
        ntr.setBalance(sd.getBalance());
        ntr.setTx_status("Success");
        return add(ntr);

    }
}

package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Transactional
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

//    public List<Transaction> getStatement(int month){
//        LocalDate curr = LocalDate.now();
//        LocalDate startDate =   LocalDate.of(curr.getYear(),month,1);
//        int lastDate = YearMonth.of(curr.getYear(),month).lengthOfMonth();
//        LocalDate endDate = LocalDate.of(curr.getYear(),month,lastDate);
//        return tr.findTransactionRangeDate(startDate,endDate);
//    }
    public Transaction sendMoney(long accountno_r,long accountno_s,float amount) {
        Account rec = ar.findByAccountno(accountno_r);
        Account sd = ar.findByAccountno(accountno_s);
        Transaction ntr = new Transaction();
        String transactionRefNo = UUID.randomUUID().toString().substring(0,10);
        LocalDateTime now = LocalDateTime.now();
        ntr.setType("Transfer");
        ntr.setTx_at(now);
        ntr.setTx_mode("Branch");
        ntr.setTx_ref_no(transactionRefNo);
        ntr.setAccountno(accountno_s);
        ntr.setAmount(amount);
        ntr.setTx_from(accountno_s);
        ntr.setTx_to(accountno_r);
        if (sd==null||rec == null||sd.getBalance() < amount||!sd.isActive()||!rec.isActive()){

            if(sd!=null) ntr.setBalance(sd.getBalance());
            if(sd==null) ntr.setTx_status("Incorrect Accno");
            else if(!sd.isActive()) ntr.setTx_status("A/C inactive");
            else if(rec == null) ntr.setTx_status("Incorrect Accno");
            else if(!rec.isActive()) ntr.setTx_status("Receiver fail");
            else if(sd.getBalance() < amount) ntr.setTx_status("Insufficent Bal");
            return add(ntr);

        }

        sd.setBalance(sd.getBalance() - amount);
        rec.setBalance(rec.getBalance() + amount);
        ar.save(sd);
        ar.save(rec);
        ntr.setBalance(sd.getBalance());
        ntr.setTx_status("Success");
        return add(ntr);

    }
}

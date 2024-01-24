package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    TransactionsRepository tr;
    public List<Transaction> getHistory(long accountno){
        return tr.getHistory(accountno);
    }
}

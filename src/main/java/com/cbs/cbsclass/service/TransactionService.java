package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    TransactionRepo tr;
    public List<Transaction> getStatement(int accountno){
        return tr.getStatement(accountno);
    }
}

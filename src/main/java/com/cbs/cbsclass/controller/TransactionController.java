package com.cbs.cbsclass.controller;

import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.TransactionRepo;
import com.cbs.cbsclass.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    TransactionService ts;
    @GetMapping("/statement")
    public List<Transaction> getStatement(@RequestParam int accountno){
        return ts.getStatement(accountno);
    }




}

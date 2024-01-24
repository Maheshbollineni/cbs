package com.cbs.cbsclass.controller;

import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    TransactionService ts;
    @GetMapping("/statement")
    public List<Transaction> getHistory(@RequestParam long accountno){
        return ts.getHistory(accountno);
    }




}

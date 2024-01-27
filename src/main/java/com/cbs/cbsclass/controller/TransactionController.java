package com.cbs.cbsclass.controller;

import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService ts;
    @GetMapping("/statement")
    public List<Transaction> getHistory(@RequestParam long accountno){
        return ts.getHistory(accountno);
    }
    @PostMapping("/transfer")
    public Transaction sendMoney(@RequestBody Tbody tbody){
        return ts.sendMoney(tbody.accountno_s,tbody.accountno_r,tbody.amount);

    }



}

class Tbody {
    long accountno_s;
    long accountno_r;
    float amount;
}
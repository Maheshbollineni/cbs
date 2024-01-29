package com.cbs.cbsclass.controller;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.dao.TransferBody;
import com.cbs.cbsclass.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TransactionController {
    @Autowired
    TransactionService ts;

    @PostMapping("/statement")
    public List<Transaction> getHistory(@RequestBody Account acc) {
        System.out.println("in /statement :" + acc.getAccountno());
        return ts.getHistory(acc.getAccountno());
    }

    @PostMapping("/transfer")
    public Transaction sendMoney(@RequestBody TransferBody tbody) {
        System.out.printf("sender: %s   \nreceiver: %s \n", tbody.getSender_accountno(), tbody.getReceiver_accountno());
        return ts.sendMoney(tbody.getSender_accountno(), tbody.getReceiver_accountno(), tbody.getAmount());


    }
}
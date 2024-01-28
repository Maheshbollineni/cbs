package com.cbs.cbsclass.controller;

import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.dao.TransferBody;
import com.cbs.cbsclass.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TransactionController {
    @Autowired
    TransactionService ts;

    @GetMapping("/statement")
    public List<Transaction> getHistory(@RequestParam long accountno) {
        return ts.getHistory(accountno);
    }

    @PostMapping("/transfer")
    public Transaction sendMoney(@RequestBody TransferBody tbody) {
        System.out.printf("sender: %s   \nreceiver: %s \n", tbody.getSender_accountno(), tbody.getReceiver_accountno());
        return ts.sendMoney(tbody.getSender_accountno(), tbody.getReceiver_accountno(), tbody.getAmount());
    }

//    @GetMapping("/monthly")
//    public List<Transaction> getStatement(@RequestParam int month){
//        return ts.getStatement(month);
//    }
}
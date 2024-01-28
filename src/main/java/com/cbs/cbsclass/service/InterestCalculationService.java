package com.cbs.cbsclass.service;

import com.cbs.cbsclass.dao.Account;
import com.cbs.cbsclass.dao.Transaction;
import com.cbs.cbsclass.repository.AccountRepo;
import com.cbs.cbsclass.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InterestCalculationService {
/*
    @Autowired
    private static AccountRepo repo;
    @Autowired
    private static TransactionsRepository transRepo;
    public static String getFormattedDate(LocalDate formatDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = formatDate.format(formatter);
//        System.out.println("Today's Date in IST format: " + formattedDate);
        return formattedDate;
    }

    public static String getQuarterStartDate(){
        LocalDate quarterStartDate = LocalDate.now(ZoneId.of("Asia/Kolkata")).minusDays(90);
        String formattedQuarterStartDate = getFormattedDate(quarterStartDate);
        System.out.println("Quarter start date:" + formattedQuarterStartDate);
        return formattedQuarterStartDate;
    }


    public static void runInterestOnAllAccounts(){
        List<Account> allAccounts = (List<Account>) repo.findAll();
        for(Account acc: allAccounts){
            calcInterest(acc);
        }
    }

    public static void calcInterest(Account acc) {
        float principle_sum = 0;
        LocalDate currentDate = LocalDate.now();
        LocalDate quarterStartDate = currentDate.minusMonths(3);
        List<Transaction> txRecords = transRepo.findIfInterestCredited(acc.getAccountno(),quarterStartDate,currentDate);
        if((!acc.isActive()) || (acc.getBalance() <= 3000) || (txRecords != null & txRecords.isEmpty())) return;

        while(!quarterStartDate.equals(currentDate)){
            List<Transaction> allTransactions = transRepo.findByDate(quarterStartDate,acc.getAccountno());
            if(!allTransactions.isEmpty()){
                for(Transaction tx: allTransactions){
                    if(tx != null){
                        principle_sum += tx.getBalance();
                    }
                }
            }
            quarterStartDate.plusDays(1);
        }
        float interestAmount = (principle_sum * 2) / (4*100);
        Transaction transaction = new Transaction();
        transaction.setIntrestamount(interestAmount);
        transRepo.save(transaction);
    }
    public static void calcInterestDaily(Account acc) {
        float interestAmount = 0;
        float principle_sum = 0;
        LocalDate currentDate = LocalDate.now();
        LocalDate quarterStartDate = currentDate.minusMonths(3);
        List<Transaction> txRecords = transRepo.findIfInterestCredited(acc.getAccountno(),quarterStartDate,currentDate);
        if((!acc.isActive()) || (acc.getBalance() <= 3000) || (txRecords != null & txRecords.isEmpty())) return;

        while(!quarterStartDate.equals(currentDate)){
            List<Transaction> allTransactions = transRepo.findByDate(quarterStartDate,acc.getAccountno());
            if(!allTransactions.isEmpty()){
                for(Transaction tx: allTransactions){
                    if(tx != null){
                        principle_sum = tx.getBalance();
                        interestAmount += (principle_sum * 2) / (36500);
                    }
                }
            }
            quarterStartDate.plusDays(1);
        }
        Transaction transaction = new Transaction();
        transaction.setIntrestamount(interestAmount);
        transRepo.save(transaction);
    }

    public static void calcInterestForAccountClosure(Account acc){
        float interestAmount = 0;
        float principle_sum = 0;
        LocalDate currentDate = LocalDate.now();
        LocalDate quarterStartDate = currentDate.minusMonths(3);
        List<Transaction> txRecords = transRepo.findIfInterestCredited(acc.getAccountno(),quarterStartDate,currentDate);
        if((!acc.isActive()) || (acc.getBalance() <= 3000) || (txRecords != null & txRecords.isEmpty())) return;

        while(!quarterStartDate.equals(currentDate)){
            List<Transaction> allTransactions = transRepo.findByDate(quarterStartDate,acc.getAccountno());
            if(!allTransactions.isEmpty()){
                for(Transaction tx: allTransactions){
                    if(tx != null){
                        principle_sum = tx.getBalance();
                        interestAmount += (principle_sum * 2) / (36500);
                    }
                }
            }
            quarterStartDate.plusDays(1);
        }
        Transaction transaction = new Transaction();
        transaction.setIntrestamount(interestAmount);
        transRepo.save(transaction);
    }*/
}

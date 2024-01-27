package com.cbs.cbsclass.repository;

import com.cbs.cbsclass.dao.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transaction,Integer> {
    public List<Transaction> findByAccountno(long accno);

    @Query("SELECT * FROM transactions WHERE tx_date <= :currDate and tx_accno = :accno order by tx_date desc limit 1")
    List<Transaction> findByDate(@Param("currDate") LocalDate currDate, @Param("tx_accno") long accno);

    @Query("SELECT * FROM transactions WHERE tx_date between :startDate and :endDate and tx_accno = :accno and interestamount is not null")
    List<Transaction> findIfInterestCredited(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("tx_accno") long accno);
}

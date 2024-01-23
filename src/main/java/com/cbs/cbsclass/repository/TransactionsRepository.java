package com.cbs.cbsclass.repository;

import com.cbs.cbsclass.dao.Customer;
import com.cbs.cbsclass.dao.Transactions;
import com.cbs.cbsclass.repository.TransactionsRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transactions,Integer> {
    public List<Transactions> findByAccNo(long accno);

    @Query("SELECT e FROM YourEntity e WHERE e.dateField BETWEEN :startDate AND :endDate")
    List<Transactions> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT * FROM transactions WHERE tx_date = :currDate and tx_accno = :accno order by tx_date limit 1")
    List<Transactions> findByDate(@Param("currDate") LocalDate currDate, @Param("tx_accno") long accno);
}

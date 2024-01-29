package com.cbs.cbsclass.repository;

import com.cbs.cbsclass.dao.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction,Integer> {
     List<Transaction> findByAccountno(long accno);
     @Query("SELECT t FROM transaction t WHERE t.accountno = ?1 AND MONTH(t.tx_at) = ?2 AND YEAR(t.tx_at) = ?3")
    List<Transaction> findTransactionRangeDate(@Param("accountno") long accountno, @Param("month") int month, @Param("year") int year);

/*    @Query("SELECT t FROM transaction WHERE tx_at <= :currDate and tx_from = :tx_accno order by tx_at desc limit 1")
    List<Transaction> findByDate(@Param("currDate") LocalDate currDate, @Param("tx_accno") long accno);

    *//*@Query("SELECT t FROM transaction WHERE tx_from = :accno and interestamount is not null and tx_at between :startDate and :endDate")
    List<Transaction> findIfInterestCredited(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("accno") long accno);*//*

    @Query("SELECT t FROM Transaction t WHERE t.txFrom = :txFrom AND t.interestAmount IS NOT NULL AND t.txAt BETWEEN :startDate AND :endDate")
    List<Transaction> findIfInterestCredited(@Param("txFrom") long txFrom, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);*/
}

package com.cbs.cbsclass.repository;

import com.cbs.cbsclass.dao.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionsRepository extends CrudRepository<Transaction,Integer> {
     List<Transaction> findByAccountno(long accno);
//     @Query("SELECT t FROM Transaction t WHERE t.tx_at BETWEEN :dateTime.isAfter(startDate) and :dateTime.isAfter(endDate)")
//     List<Transaction> findTransactionRangeDate(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
    @Query("SELECT t FROM transaction t WHERE tx_at <= ?1 and tx_from = ?2 order by tx_at desc limit 1")
    List<Transaction> findByDate(@Param("currDate") LocalDateTime currDate, @Param("tx_accno") long accno);

     /*@Query("SELECT t FROM transaction WHERE tx_from = :accno and interestamount is not null and tx_at between :startDate and :endDate")
    List<Transaction> findIfInterestCredited(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("accno") long accno);*/

    @Query("SELECT t FROM transaction t WHERE t.tx_from = ?1 AND t.interestamount IS NOT NULL AND t.tx_at BETWEEN ?2 AND ?3")
    List<Transaction> findIfInterestCredited(@Param("txFrom") long txFrom, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}

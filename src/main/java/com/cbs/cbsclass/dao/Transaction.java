package com.cbs.cbsclass.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Entity(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String tx_ref_no;

    @Column
    private long accountno;

    @Column
    private String type;

    @Column
    private float amount;

    @Column
    private float balance;

    @Column
    @Getter @Setter private LocalDateTime tx_at;
    @Column
    private long tx_from;

    @Column
    private long tx_to;

    @Column
    private String tx_mode;

    @Column
    private String tx_status;

    @Column
    private float interestamount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTx_ref_no() {
        return tx_ref_no;
    }

    public void setTx_ref_no(String tx_ref_no) {
        this.tx_ref_no = tx_ref_no;
    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public long getTx_from() {
        return tx_from;
    }

    public void setTx_from(long tx_from) {
        this.tx_from = tx_from;
    }

    public long getTx_to() {
        return tx_to;
    }

    public void setTx_to(long tx_to) {
        this.tx_to = tx_to;
    }

    public String getTx_mode() {
        return tx_mode;
    }

    public void setTx_mode(String tx_mode) {
        this.tx_mode = tx_mode;
    }

    public String getTx_status() {
        return tx_status;
    }

    public void setTx_status(String tx_status) {
        this.tx_status = tx_status;
    }

    public double getIntrestamount() {
        return interestamount;
    }

    public void setIntrestamount(float intrestamount) {
        this.interestamount = intrestamount;
    }
}

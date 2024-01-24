package com.cbs.cbsclass.dao;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String tx_ref_no;

    @Column
    private int accountno;

    @Column
    private String type;

    @Column
    private double amount;

    @Column
    private double balance;

    @Column
    private int tx_from;

    @Column
    private int tx_to;

    @Column
    private String tx_mode;

    @Column
    private String tx_status;

    @Column
    private int intrestamount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTx_ref_no() {
        return tx_ref_no;
    }

    public void setTx_ref_no(String tx_ref_no) {
        this.tx_ref_no = tx_ref_no;
    }

    public int getAccountno() {
        return accountno;
    }

    public void setAccountno(int accountno) {
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTx_from() {
        return tx_from;
    }

    public void setTx_from(int tx_from) {
        this.tx_from = tx_from;
    }

    public int getTx_to() {
        return tx_to;
    }

    public void setTx_to(int tx_to) {
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

    public int getIntrestamount() {
        return intrestamount;
    }

    public void setIntrestamount(int intrestamount) {
        this.intrestamount = intrestamount;
    }
}

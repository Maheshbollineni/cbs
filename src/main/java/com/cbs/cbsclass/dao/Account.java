package com.cbs.cbsclass.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    private long accountno;

    @Column
    private String custid;

    @Column
    private String ifsccode;

    @Column
    private String branch;

    @Column
    private String accounttype;

    @Column
    private double balance;

    @Column
    private boolean isActive;

    @Column
    @Getter @Setter private String nominee1;

    @Column
    @Getter @Setter private String nominee2;

    @Column
    @Getter @Setter private String upiid;

    @Column
    @Getter @Setter private String category;

    @Column
    @Getter @Setter private long debitcardno;

    @Column
    @Getter @Setter private long creditcardno;

    @Column
    @Getter @Setter private boolean enablednetbanking;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}

package com.cbs.cbsclass.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity

public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter  private int id;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    @Column
    @Getter @Setter private String custid;


    @Column
    @Getter @Setter private String password;


    @Column
    @Getter @Setter private String firstname;

    @Column
    @Getter @Setter private String middlename;


    @Column
    @Getter @Setter private String lastname;


    @Column
    @Getter @Setter private String mobileno;

    @Column
    @Getter @Setter private String emailid;


    @Column
    @Getter @Setter private String address;


    @Column
    @Getter @Setter private String country;

    @Column
    @Getter @Setter private String state;

    @Column
    @Getter @Setter private Date date;

    @Column
    @Getter @Setter private String city;

    @Column
    @Getter @Setter private int pin;

    @Column
    @Getter @Setter private String fathername;

    @Column
    @Getter @Setter private String mothername;

    @Column
    @Getter @Setter private String pan;

    @Column
    @Getter @Setter private String aadharid;

    @Column
    @Getter @Setter private boolean isactive;


}

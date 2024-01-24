package com.cbs.cbsclass.dao;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @Column
    @Getter @Setter private int empid;

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
    @Getter @Setter private Date dob;

    @Column
    @Getter @Setter private boolean isactive;





}

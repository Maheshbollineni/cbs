package com.cbs.cbsclass.dao;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column
    @Getter @Setter private LocalDateTime createdat;

    @Column
    @Getter @Setter private LocalDateTime updatedat;

    @Column
    @Getter @Setter private String createdby;

    @Column
    @Getter @Setter private String updatedby;




}

package com.ezbytes.loans.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loans")
@Getter
@Setter
public class LoansEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanNumber;

    @Column
    private int customerId;

    @Column
    private Date startDt;

    @Column
    private String loanType;

    @Column
    private int totalLoan;

    @Column
    private int amountPaid;

    @Column
    private int outstandingAmount;

    @Column
    private String createDt;

}

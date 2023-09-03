package com.bank.account.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

import java.math.BigDecimal;

/**
 * Account details entity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
@Table(name = "account_details")
public class AccountDetails {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "passport_id")
    long passportId;

    @Column(name = "account_number", unique = true)
    long accountNumber;

    @Column(name = "bank_details_id", unique = true)
    long bankDetailsId;

    @Column(name = "money")
    BigDecimal money;

    @Column(name = "negative_balance")
    boolean negativeBalance;

    @Column(name = "profile_id")
    long profileId;
}


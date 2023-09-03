package com.bank.account.service;

import com.bank.account.entity.AccountDetails;

import java.util.List;
import java.util.Optional;

public interface AccountDetailsService {
    List<AccountDetails> getAllAccountDetails();

    Optional<AccountDetails> getAccountDetailsById(long id);

    void createAccountDetails(AccountDetails accountDetails);

    void updateAccountDetails(AccountDetails accountDetails);

    void deleteAccountDetails(AccountDetails accountDetails);
}

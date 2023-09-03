package com.bank.account.service.Impl;

import com.bank.account.entity.AccountDetails;
import com.bank.account.repository.AccountDetailsRepository;
import com.bank.account.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * implementation of the service for working with the Account details entity
 */

@Service
@Transactional
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private AccountDetailsRepository accountDetailsRepository;

    @Autowired
    public AccountDetailsServiceImpl(AccountDetailsRepository accountDetailsRepository) {
        this.accountDetailsRepository = accountDetailsRepository;
    }

    @Override
    public List<AccountDetails> getAllAccountDetails() {
        return accountDetailsRepository.findAll();
    }

    @Override
    public Optional<AccountDetails> getAccountDetailsById(long id) {
        return accountDetailsRepository.findById(id);
    }

    @Override
    public void createAccountDetails(AccountDetails accountDetails) {
        accountDetailsRepository.save(accountDetails);
    }

    @Override
    public void updateAccountDetails(AccountDetails accountDetails) {
        accountDetailsRepository.save(accountDetails);
    }

    @Override
    public void deleteAccountDetails(AccountDetails accountDetails) {
        accountDetailsRepository.delete(accountDetails);
    }
}

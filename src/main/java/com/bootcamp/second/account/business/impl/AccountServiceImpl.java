package com.bootcamp.second.account.business.impl;

import com.bootcamp.second.account.business.AccountService;
import com.bootcamp.second.account.model.Account;
import com.bootcamp.second.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Mono<Account> create(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Account> findById(String accountId) {
        
        return accountRepository.findById(accountId);
    }

    @Override
    public Flux<Account> findAll() {
        
        return accountRepository.findAll();
    }

    @Override
    public Mono<Account> update(Account account) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Account> remove(String accountId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<Account> findAccountByOwner(String owner) {
        
        return accountRepository.findAccountsByOwner(owner);
    }

    @Override
    public Flux<Account> findAccountByAcc_Type(String acc_type) {
        
        return accountRepository.findAccountsByAcc_Type(acc_type);
    }

    @Override
    public Flux<Account> findAccountByTr_Limit(String tr_limit) {
        
        return accountRepository.findAccountsByTr_Limit(tr_limit);
    }
    
}

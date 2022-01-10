package com.bootcamp.second.account.business;

import com.bootcamp.second.account.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<Account> create(Account account);

    Mono<Account> findById(String accountId);

    Flux<Account> findAll();
    
    Mono<Account> update(Account account);

    Mono<Account> remove(String accountId);

    Flux<Account> findAccountByOwner(String owner);

    Flux<Account> findAccountByAcc_Type(String acc_type);

    Flux<Account> findAccountByTr_Limit(String tr_limit);
}
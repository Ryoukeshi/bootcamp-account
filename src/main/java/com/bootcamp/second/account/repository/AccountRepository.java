package com.bootcamp.second.account.repository;

import com.bootcamp.second.account.model.Account;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String>{

    Flux<Account> findAccountsByOwner(String owner);
    
    Flux<Account> findAccountsByAcc_Type(String acc_type);

    Flux<Account> findAccountsByTr_Limit(String tr_limit);
}

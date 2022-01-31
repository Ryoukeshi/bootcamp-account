package com.bootcamp.second.account.repository;

import com.bootcamp.second.account.model.Account;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String>{

    Flux<Account> findByOwner(String owner);
    
    Flux<Account> findAccountsByAccType(String acc_type);

    Flux<Account> findAccountsByTrLimit(String tr_limit);
}

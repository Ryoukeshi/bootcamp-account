package com.bootcamp.second.account.business;

import com.bootcamp.second.account.model.dto.AccountDTO;
import com.bootcamp.second.account.model.dto.BCoinDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<AccountDTO> create(AccountDTO account);

    Mono<AccountDTO> findById(String accountId);

    Flux<AccountDTO> findAll();
    
    Mono<AccountDTO> update(String id, AccountDTO account);

    Mono<AccountDTO> remove(String accountId);

    Flux<AccountDTO> findAccountByOwner(String owner);

    Flux<AccountDTO> findAccountByAccType(String acc_type);

    Flux<AccountDTO> findAccountByTrLimit(String tr_limit);
}
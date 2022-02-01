package com.bootcamp.second.account.business;

import com.bootcamp.second.account.model.dto.BCoinDTO;
import com.bootcamp.second.account.model.dto.TransactionDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionDTO> create(TransactionDTO transactionDTO);

    Mono<TransactionDTO> findById(String id);

    Flux<TransactionDTO> findAll();

    Mono<TransactionDTO> update(String id, TransactionDTO transactionDTO);

    Mono<TransactionDTO> remove(String id);
}

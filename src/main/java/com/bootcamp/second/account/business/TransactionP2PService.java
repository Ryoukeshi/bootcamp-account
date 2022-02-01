package com.bootcamp.second.account.business;

import com.bootcamp.second.account.model.dto.TransactionP2PDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionP2PService {

    Mono<TransactionP2PDTO> create(TransactionP2PDTO transactionP2PDTO);

    Mono<TransactionP2PDTO> update(String id, TransactionP2PDTO transactionP2PDTO);

    Mono<TransactionP2PDTO> findById(String id);

    Flux<TransactionP2PDTO> findAll();

    Mono<TransactionP2PDTO> remove(String id);
}

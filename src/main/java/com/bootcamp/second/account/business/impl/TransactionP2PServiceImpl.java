package com.bootcamp.second.account.business.impl;

import com.bootcamp.second.account.business.TransactionP2PService;
import com.bootcamp.second.account.model.TransactionP2P;
import com.bootcamp.second.account.model.dto.TransactionP2PDTO;
import com.bootcamp.second.account.repository.TransactionP2PRepository;
import com.bootcamp.second.account.utils.Constants;
import com.bootcamp.second.account.utils.ConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionP2PServiceImpl implements TransactionP2PService {

    @Autowired
    TransactionP2PRepository transactionP2PRepository;


    @Override
    public Mono<TransactionP2PDTO> create(TransactionP2PDTO transactionP2PDTO) {
        return transactionP2PRepository.findById(transactionP2PDTO.getId())
                .switchIfEmpty(Mono.just(new TransactionP2P()))
                .flatMap(transactionP2P -> ConversionUtils.createTransactionP2PEntity(transactionP2PDTO))
                .map(ConversionUtils::transactionP2PDTOToEntity)
                .flatMap(transactionP2PRepository::save)
                .map(ConversionUtils::entityToTransactionP2PDTO);
    }

    @Override
    public Mono<TransactionP2PDTO> update(String id, TransactionP2PDTO transactionP2PDTO) {
        return transactionP2PRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(transactionP2P -> ConversionUtils.updateTransactionP2PEntity(transactionP2PDTO, id))
                .map(ConversionUtils::transactionP2PDTOToEntity)
                .flatMap(transactionP2PRepository::save)
                .map(ConversionUtils::entityToTransactionP2PDTO);
    }

    @Override
    public Mono<TransactionP2PDTO> findById(String id) {
        return transactionP2PRepository.findById(id)
                .filter(transactionP2P -> transactionP2P.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToTransactionP2PDTO);
    }

    @Override
    public Flux<TransactionP2PDTO> findAll() {
        return transactionP2PRepository.findAll()
                .filter(transactionP2P -> transactionP2P.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToTransactionP2PDTO);
    }

    @Override
    public Mono<TransactionP2PDTO> remove(String id) {
        return transactionP2PRepository.findById(id)
                .doOnNext(transactionP2P -> transactionP2P.setStatus(Constants.INACTIVE.name()))
                .flatMap(transactionP2PRepository::save)
                .map(ConversionUtils::entityToTransactionP2PDTO);
    }
}

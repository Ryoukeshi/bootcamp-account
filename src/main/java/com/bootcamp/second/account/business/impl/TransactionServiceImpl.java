package com.bootcamp.second.account.business.impl;

import com.bootcamp.second.account.business.TransactionService;
import com.bootcamp.second.account.model.Transaction;
import com.bootcamp.second.account.model.dto.BCoinDTO;
import com.bootcamp.second.account.model.dto.TransactionDTO;
import com.bootcamp.second.account.repository.TransactionRepository;
import com.bootcamp.second.account.utils.Constants;
import com.bootcamp.second.account.utils.ConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Mono<TransactionDTO> create(TransactionDTO transactionDTO) {

        return transactionRepository.findById(transactionDTO.getId())
                .switchIfEmpty(Mono.just(new Transaction()))
                .flatMap(transaction -> ConversionUtils.createTransactionEntity(transactionDTO))
                .map(ConversionUtils::transactionDTOtoEntity)
                .flatMap(transactionRepository::save)
                .map(ConversionUtils::entityToTransactionDTO);
    }

    @Override
    public Mono<TransactionDTO> findById(String id) {
        return transactionRepository.findById(id)
                .filter(transaction -> transaction.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToTransactionDTO);
    }

    @Override
    public Flux<TransactionDTO> findAll() {
        return transactionRepository.findAll()
                .filter(transaction -> transaction.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToTransactionDTO);
    }

    @Override
    public Mono<TransactionDTO> update(String id, TransactionDTO transactionDTO) {
        return transactionRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(transaction -> ConversionUtils.updateTransactionEntity(transactionDTO, id))
                .map(ConversionUtils::transactionDTOtoEntity)
                .flatMap(transactionRepository::save)
                .map(ConversionUtils::entityToTransactionDTO);
    }

    @Override
    public Mono<TransactionDTO> remove(String id) {
        return transactionRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .doOnNext(transaction -> transaction.setStatus(Constants.INACTIVE.name()))
                .flatMap(transactionRepository::save)
                .map(ConversionUtils::entityToTransactionDTO);
    }
}

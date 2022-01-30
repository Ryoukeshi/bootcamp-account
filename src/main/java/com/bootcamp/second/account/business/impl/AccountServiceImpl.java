package com.bootcamp.second.account.business.impl;

import com.bootcamp.second.account.business.AccountService;
import com.bootcamp.second.account.model.Account;
import com.bootcamp.second.account.model.AccountDTO;
import com.bootcamp.second.account.repository.AccountRepository;

import com.bootcamp.second.account.utils.Constants;
import com.bootcamp.second.account.utils.ConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Mono<AccountDTO> create(AccountDTO accountDTO) {
        
        return accountRepository.findById(accountDTO.getId())
                .switchIfEmpty(Mono.just(new Account()))
                .flatMap(account1 -> ConversionUtils.createAccountEntity(accountDTO))
                .map(ConversionUtils::accountDtoToEntity)
                .flatMap(accountRepository::insert)
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Mono<AccountDTO> findById(String accountId) {
        
        return accountRepository.findById(accountId)
                .switchIfEmpty(Mono.empty())
                .filter(account -> account.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Flux<AccountDTO> findAll() {
        
        return accountRepository.findAll()
                .filter(account -> account.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Mono<AccountDTO> update(AccountDTO accountDTO) {
        
        return accountRepository.findById(accountDTO.getId())
                .switchIfEmpty(Mono.empty())
                .flatMap(account1 -> ConversionUtils.updateAccountEntity(accountDTO, accountDTO.getId()))
                .map(ConversionUtils::accountDtoToEntity)
                .flatMap(accountRepository::save)
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Mono<AccountDTO> remove(String accountId) {
        
        return accountRepository.findById(accountId)
                .switchIfEmpty(Mono.empty())
                .doOnNext(account -> account.setStatus(Constants.INACTIVE.name()))
                .flatMap(accountRepository::save)
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Flux<AccountDTO> findAccountByOwner(String owner) {
        
        return accountRepository.findByOwner(owner)
                .switchIfEmpty(Flux.empty())
                .filter(account -> account.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Flux<AccountDTO> findAccountByAccType(String acc_type) {
        
        return accountRepository.findAccountsByAccType(acc_type)
                .switchIfEmpty(Flux.empty())
                .filter(account -> account.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToAccountDTO);
    }

    @Override
    public Flux<AccountDTO> findAccountByTrLimit(String tr_limit) {
        
        return accountRepository.findAccountsByTrLimit(tr_limit)
                .switchIfEmpty(Flux.empty())
                .filter(account -> account.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToAccountDTO);
    }
    
}

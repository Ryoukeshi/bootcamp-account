package com.bootcamp.second.account.utils;

import com.bootcamp.second.account.model.Account;
import com.bootcamp.second.account.model.Transaction;
import com.bootcamp.second.account.model.TransactionP2P;
import com.bootcamp.second.account.model.dto.AccountDTO;
import com.bootcamp.second.account.model.dto.TransactionDTO;
import com.bootcamp.second.account.model.dto.TransactionP2PDTO;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

public class ConversionUtils {

    public static AccountDTO entityToAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account, accountDTO);
        return accountDTO;
    }

    public static Account accountDtoToEntity(AccountDTO accountDTO){
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        return account;
    }

    public static Mono<AccountDTO> createAccountEntity(AccountDTO accountDTO){
        AccountDTO modifiedAccountDTO = new AccountDTO();
        BeanUtils.copyProperties(accountDTO, modifiedAccountDTO);
        modifiedAccountDTO.setStatus(Constants.ACTIVE.name());
        return Mono.just(modifiedAccountDTO);
    }

    public static Mono<AccountDTO> updateAccountEntity(AccountDTO accountDTO, String id){
        AccountDTO modifiedAccountDTO = new AccountDTO();
        BeanUtils.copyProperties(accountDTO, modifiedAccountDTO);
        modifiedAccountDTO.setId(id);
        return Mono.just(modifiedAccountDTO);
    }

    public static TransactionDTO entityToTransactionDTO(Transaction transaction){
        TransactionDTO transactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transaction, transactionDTO);
        return transactionDTO;
    }

    public static Transaction transactionDTOtoEntity(TransactionDTO transactionDTO){
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDTO, transaction);
        return transaction;
    }

    public static Mono<TransactionDTO> createTransactionEntity(TransactionDTO transactionDTO){
        TransactionDTO modifiedTransactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transactionDTO, modifiedTransactionDTO);
        modifiedTransactionDTO.setStatus(Constants.ACTIVE.name());
        return Mono.just(modifiedTransactionDTO);
    }

    public static Mono<TransactionDTO> updateTransactionEntity(TransactionDTO transactionDTO, String id){
        TransactionDTO modifiedTransactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transactionDTO, modifiedTransactionDTO);
        modifiedTransactionDTO.setId(id);
        return Mono.just(modifiedTransactionDTO);
    }

    public static TransactionP2PDTO entityToTransactionP2PDTO(TransactionP2P transactionP2P){
        TransactionP2PDTO transactionP2PDTO = new TransactionP2PDTO();
        BeanUtils.copyProperties(transactionP2P, transactionP2PDTO);
        return transactionP2PDTO;
    }

    public static TransactionP2P transactionP2PDTOToEntity(TransactionP2PDTO transactionP2PDTO){
        TransactionP2P transactionP2P = new TransactionP2P();
        BeanUtils.copyProperties(transactionP2PDTO, transactionP2P);
        return transactionP2P;
    }

    public static Mono<TransactionP2PDTO> createTransactionP2PEntity(TransactionP2PDTO transactionP2PDTO){
        TransactionP2PDTO modifiedTransactionP2PDTO = new TransactionP2PDTO();
        BeanUtils.copyProperties(transactionP2PDTO, modifiedTransactionP2PDTO);
        modifiedTransactionP2PDTO.setStatus(Constants.ACTIVE.name());
        return Mono.just(modifiedTransactionP2PDTO);
    }

    public static Mono<TransactionP2PDTO> updateTransactionP2PEntity(TransactionP2PDTO transactionP2PDTO, String id){
        TransactionP2PDTO modifiedTransactionP2PDTO = new TransactionP2PDTO();
        BeanUtils.copyProperties(transactionP2PDTO, modifiedTransactionP2PDTO);
        modifiedTransactionP2PDTO.setId(id);
        return Mono.just(modifiedTransactionP2PDTO);
    }
}

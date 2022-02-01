package com.bootcamp.second.account.controller;

import com.bootcamp.second.account.business.AccountService;

import com.bootcamp.second.account.business.TransactionP2PService;
import com.bootcamp.second.account.business.TransactionService;
import com.bootcamp.second.account.model.dto.AccountDTO;
import com.bootcamp.second.account.model.BCoin;
import com.bootcamp.second.account.model.dto.BCoinDTO;
import com.bootcamp.second.account.model.dto.TransactionDTO;
import com.bootcamp.second.account.model.dto.TransactionP2PDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionP2PService transactionP2PService;

    @GetMapping("/api/accounts/{id}")
    public Mono<AccountDTO> byId(@PathVariable ("id") String id) {

        log.info("----getById----");

        return accountService.findById(id);
    }

    @GetMapping("/api/accounts")
    public Flux<AccountDTO> findAll(){
        log.info("---getAll---");

        return accountService.findAll();
    }

    @GetMapping("/api/accounts/findByOwner")
    public Flux<AccountDTO> byOwner(@RequestParam ("owner") String owner) {

        log.info("----getByOwner----");

        return accountService.findAccountByOwner(owner);
    }

    @PutMapping("/api/accounts/{id}")
    public Mono<ResponseEntity<AccountDTO>> update(@PathVariable ("id") String id, @RequestBody AccountDTO accountDTO) {

        log.info("----update----");

        return accountService.update(id, accountDTO)
            .flatMap(accountUpdate -> Mono.just(ResponseEntity.ok(accountUpdate)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
    @PostMapping("/api/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AccountDTO> create(@RequestBody AccountDTO accountDTO) {

        log.info("----create----");

        return accountService.create(accountDTO);
    }

    @DeleteMapping("/api/accounts/{id}")
    public Mono<AccountDTO> remove(@PathVariable ("id") String id){
        log.info("---removing---");

        return accountService.remove(id);
    }

    /********Transactions*********/

    @PostMapping("/api/transactions")
    public Mono<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO){
        log.info("---createTransaction---");

        return transactionService.create(transactionDTO);
    }

    @GetMapping("/api/transactions/{id}")
    public Mono<TransactionDTO> findTransactionById(@PathVariable ("id") String id){
        log.info("---findTransactionById---");

        return transactionService.findById(id);
    }

    @GetMapping("/api/transactions")
    public Flux<TransactionDTO> findAllTransactions(){
        log.info("---findAllTransactions---");

        return transactionService.findAll();
    }

    @PutMapping("/api/transactions/{id}")
    public Mono<TransactionDTO> update(@PathVariable ("id") String id, TransactionDTO transactionDTO){
        log.info("---updateTransaction---");

        return transactionService.update(id, transactionDTO);
    }

    @DeleteMapping("/api/transactions")
    public Mono<TransactionDTO> removeTransaction(String id){
        log.info("---deleteTransaction---");

        return transactionService.remove(id);
    }

    /*********TransactionP2P*********/

    @PostMapping("/api/p2p")
    public Mono<TransactionP2PDTO> createTransactionP2P(@RequestBody TransactionP2PDTO transactionP2PDTO){
        log.info("---createTransactionP2P---");

        return transactionP2PService.create(transactionP2PDTO);
    }

    @GetMapping("/api/p2p/{id}")
    public Mono<TransactionP2PDTO> findTransactionP2PById(@PathVariable ("id") String id){
        log.info("---findTransactionP2PById---");

        return transactionP2PService.findById(id);
    }

    @GetMapping("/api/p2p")
    public Flux<TransactionP2PDTO> findAllTransactionsP2P(){
        log.info("---findAllTransactionsP2P---");

        return transactionP2PService.findAll();
    }

    @PutMapping("/api/p2p/{id}")
    public Mono<TransactionP2PDTO> updateTransactionP2P(@PathVariable ("id") String id,
                                                        @RequestBody TransactionP2PDTO transactionP2PDTO){
        log.info("---updateTransactionP2P---");

        return transactionP2PService.update(id, transactionP2PDTO);
    }

    @DeleteMapping("/api/p2p/{id}")
    public Mono<TransactionP2PDTO> deleteTransactionP2P(@PathVariable String id){
        log.info("---deleteTransactionP2P---");

        return transactionP2PService.remove(id);
    }
}

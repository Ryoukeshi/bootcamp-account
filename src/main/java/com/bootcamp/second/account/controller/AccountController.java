package com.bootcamp.second.account.controller;

import com.bootcamp.second.account.business.AccountService;
import com.bootcamp.second.account.model.Account;

import com.bootcamp.second.account.model.AccountDTO;
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

        return accountService.update(accountDTO)
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
}

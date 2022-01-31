package com.bootcamp.second.account.utils;

import com.bootcamp.second.account.model.Account;
import com.bootcamp.second.account.model.AccountDTO;
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
}

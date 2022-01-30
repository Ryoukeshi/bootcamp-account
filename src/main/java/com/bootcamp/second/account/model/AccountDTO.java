package com.bootcamp.second.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String id;

    private Client owner;
    private String accType;
    private String maintenance;
    private String trLimit;
    private String transferFee;
    private String status;
}

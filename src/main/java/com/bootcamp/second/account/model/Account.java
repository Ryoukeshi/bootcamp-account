package com.bootcamp.second.account.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection = "account")
public class Account {

    @Id
    private String id = UUID.randomUUID().toString();
    
    private String owner;
    private String acc_type;
    private String maintenance;
    private String tr_limit;
    private String status;
}
package com.bootcamp.second.account.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;

    @Field(name = "owner")
    private Client owner;

    @Field(name = "accType")
    private String accType;

    @Field(name = "maintenance")
    private String maintenance;

    @Field(name = "trLimit")
    private String trLimit;

    @Field(name = "transferFee")
    private String transferFee;

    @Field(name = "status")
    private String status;
}

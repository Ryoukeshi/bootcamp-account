package com.bootcamp.second.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "bcoinpurse")
public class BCoinPurse {

    @Field(name = "id")
    @Id
    private String id;

    @Field(name = "documenType")
    private String documentType;

    @Field(name = "documentNumber")
    private String documentNumber;

    @Field(name = "phoneNumber")
    private String phoneNumber;

    @Field(name = "email")
    private String email;

    @Field(name = "amount")
    private String amount;

    @Field(name = "transactionHistory")
    private ArrayList<TransactionP2P> transactionHistory;
}


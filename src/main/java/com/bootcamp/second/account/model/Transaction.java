package com.bootcamp.second.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "documents")
public class Transaction {

    @Field(name = "id")
    private String id;

    @Field(name = "accountOriginNumber")
    private String accountOriginNumber;

    @Field(name = "accountDestinyNumber")
    private String accountDestinyNumber;

    @Field(name = "currencyType")
    private String currencyType;

    @Field(name = "amount")
    private String amount;

    @Field(name = "date")
    private String date;

    @Field(name = "status")
    private String status;
}

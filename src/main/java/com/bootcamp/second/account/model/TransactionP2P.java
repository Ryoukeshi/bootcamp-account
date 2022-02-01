package com.bootcamp.second.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
public class TransactionP2P {

    @Field(name = "id")
    @Id
    private String id;

    @Field(name = "transactionType")
    private String transactionType;

    @Field(name = "userOrigin")
    private String userOrigin;

    @Field(name = "userTarget")
    private String userTarget;

    @Field(name = "paymentMethod")
    private String paymentMethod;

    @Field(name = "bCoin")
    private BCoin bCoin;

    @Field(name = "amount")
    private String amount;

    @Field(name = "date")
    private String date;

    @Field(name = "status")
    private String status;
}
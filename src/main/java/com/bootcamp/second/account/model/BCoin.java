package com.bootcamp.second.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
public class BCoin {

    @Field(name = "id")
    @Id
    private String id;

    @Field(name = "buyFee")
    private double buyFee;

    @Field(name = "sellFee")
    private double sellFee;

    @Field(name = "purseId")
    private String purseId;
}

package com.bootcamp.second.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class BCoin {

    @Id
    private String id;
    private double buyFee;
    private double sellFee;
    private String purseId;
}

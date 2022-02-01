package com.bootcamp.second.account.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {

    @Id
    private String id;
    private String accountOriginNumber;
    private String accountDestinyNumber;
    private String currencyType;
    private String amount;
    private String date;
    private String status;
}

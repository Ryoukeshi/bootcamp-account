package com.bootcamp.second.account.model.dto;

import com.bootcamp.second.account.model.BCoin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class TransactionP2PDTO {

    @Id
    private String id;
    private String transactionType;
    private String userOrigin;
    private String userTarget;
    private String paymentMethod;
    private BCoin bCoin;
    private String amount;
    private String date;
    private String status;
}

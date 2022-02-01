package com.bootcamp.second.account.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BCoinDTO {

    private String id;
    private String buyFee;
    private String sellFee;
    private String purseId;
}

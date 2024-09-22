package com.eazycode.cards.dao;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CardsDAO {

    private String cardNumber;

    private String cardType;

    private String mobileNumber;

    private Integer totalLimit;

    private Integer amountUsed;

    private Integer availableAmount;
}

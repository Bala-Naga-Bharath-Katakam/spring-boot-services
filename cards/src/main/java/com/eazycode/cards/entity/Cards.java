package com.eazycode.cards.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private String cardNumber;

    private String cardType;

    private String mobileNumber;

    private Integer totalLimit;

    private Integer amountUsed;

    private Integer availableAmount;

}

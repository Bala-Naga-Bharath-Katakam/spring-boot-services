package com.easycoding.accounts.dao;

import com.easycoding.accounts.service.client.CardsDAO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDetails {

    private CustomerDAO customerDAO;

    private CardsDAO cardsDAO;
}

package com.eazycode.cards.service;

import com.eazycode.cards.dao.CardsDAO;
import com.eazycode.cards.entity.Cards;

public interface CardsService {

    public Cards save(CardsDAO cardsDAO);
    public Cards findByMobileNumber(String mobileNumber);
}

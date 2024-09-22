package com.eazycode.cards.service;

import com.eazycode.cards.dao.CardsDAO;
import com.eazycode.cards.entity.Cards;
import com.eazycode.cards.repository.CardsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardsServiceImpl implements CardsService{

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public Cards save(CardsDAO cardsDAO) {
        ModelMapper modelMapper = new ModelMapper();
        Cards cards = new Cards();
        modelMapper.map(cardsDAO,cards);
        Cards savedCard = cardsRepository.save(cards);
        return cards;
    }

    @Override
    public Cards findByMobileNumber(String mobileNumber) {

        Optional<Cards> cardDetails = cardsRepository.findByMobileNumber(mobileNumber);
        return cardDetails.get();
    }
}

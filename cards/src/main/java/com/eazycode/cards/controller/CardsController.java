package com.eazycode.cards.controller;

import com.eazycode.cards.dao.CardsDAO;
import com.eazycode.cards.entity.Cards;
import com.eazycode.cards.service.CardsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @PostMapping("/create")
    public ResponseEntity<CardsDAO> createCard(@RequestBody CardsDAO cardsDAO){

        Cards savedCards = cardsService.save(cardsDAO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardsDAO);
    }


    @GetMapping("/getCardDetails")
    public ResponseEntity<CardsDAO> getCardDetails(@RequestParam String mobileNumber){
        Cards cards = cardsService.findByMobileNumber(mobileNumber);
        ModelMapper modelMapper = new ModelMapper();
        CardsDAO cardDAO = new CardsDAO();
        modelMapper.map(cards,cardDAO);
        return ResponseEntity.status(HttpStatus.OK).body(cardDAO);
    }

}

package com.easycoding.accounts.controller;

import com.easycoding.accounts.dao.AccountsDAO;
import com.easycoding.accounts.dao.CustomerDAO;
import com.easycoding.accounts.dao.CustomerDetails;
import com.easycoding.accounts.dao.config.AccountsContactInfoDto;
import com.easycoding.accounts.enitity.Accounts;
import com.easycoding.accounts.enitity.Customer;
import com.easycoding.accounts.service.AccountService;
import com.easycoding.accounts.service.client.CardsClient;
import com.easycoding.accounts.service.client.CardsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;


    @Autowired
    private CardsClient cardsClient;

    @PostMapping("/create")
    public ResponseEntity<Accounts> createAccount(@RequestBody CustomerDAO customerDAO){
        Accounts savedAccount = accountService.save(customerDAO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAccount);
    }

    @GetMapping("/getCardDetails")
    public ResponseEntity<CustomerDetails> getCustomer(@RequestBody CustomerDAO customerDAO){
        Long mobileNumber = customerDAO.getMobileNumber();
        ResponseEntity<CardsDAO> cardDetails = cardsClient.getCardDetails(String.valueOf(mobileNumber));
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerDAO(customerDAO);
        customerDetails.setCardsDAO(cardDetails.getBody());
        return ResponseEntity.status(HttpStatus.OK).body(customerDetails);
    }

    @GetMapping("/contactInfo")
    public ResponseEntity<AccountsContactInfoDto> getContactDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(accountsContactInfoDto);
    }
}



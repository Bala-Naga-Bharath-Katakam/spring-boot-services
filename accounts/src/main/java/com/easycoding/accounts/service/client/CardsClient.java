package com.easycoding.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsClient {

    @GetMapping("/getCardDetails")
    public ResponseEntity<CardsDAO> getCardDetails(@RequestParam String mobileNumber);
}

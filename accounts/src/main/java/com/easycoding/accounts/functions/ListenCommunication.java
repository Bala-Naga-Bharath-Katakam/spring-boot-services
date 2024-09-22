package com.easycoding.accounts.functions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ListenCommunication {

    @Bean
    public Consumer<Long> updateCommunication(){
        return accountNumber -> {
            log.info("Updating Communication status for the account number : " + accountNumber.toString());
        };}
}

package com.easycoding.accounts.service;


import com.easycoding.accounts.dao.AccountsDAO;
import com.easycoding.accounts.dao.AccountsMsgDto;
import com.easycoding.accounts.dao.CustomerDAO;
import com.easycoding.accounts.enitity.Accounts;
import com.easycoding.accounts.enitity.Customer;
import com.easycoding.accounts.repository.AccountsRepository;
import com.easycoding.accounts.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountsDAOImpl implements AccountService{

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StreamBridge streamBridge;


    @Override
    public Accounts save(CustomerDAO customerDAO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = new Customer();
        modelMapper.map(customerDAO,customer);
        Customer savedCustomer = customerRepository.save(customer);
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(generateAccountNumber());
        accounts.setAccountType("SAVINGS");
        accounts.setCustomerId(savedCustomer.getCustomerId());
        accounts.setBranchAddress("MACHILIPATNAM");
        Accounts savedAccount = accountsRepository.save(accounts);
        AccountsMsgDto accountsMsgDto = new AccountsMsgDto(generateAccountNumber(),customer.getName(),customer.getEmail(),
                String.valueOf(customer.getMobileNumber()));
        streamBridge.send("send-communication",accountsMsgDto);
        return savedAccount;
    }

    public static long generateAccountNumber() {
        Random random = new Random();
        long accountNumber = Math.abs(random.nextLong());

        // Ensure the account number is a positive value
        if (accountNumber < 0) {
            accountNumber = -accountNumber;
        }

        return accountNumber;
    }
}

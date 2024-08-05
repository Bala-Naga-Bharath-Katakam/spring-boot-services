package com.easycoding.accounts.service;

import com.easycoding.accounts.dao.AccountsDAO;
import com.easycoding.accounts.dao.CustomerDAO;
import com.easycoding.accounts.enitity.Accounts;
import org.springframework.stereotype.Service;

public interface AccountService {

    public Accounts save(CustomerDAO customerDAO);

}

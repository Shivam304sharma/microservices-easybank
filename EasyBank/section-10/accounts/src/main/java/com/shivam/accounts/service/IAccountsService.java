package com.shivam.accounts.service;

import com.shivam.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface IAccountsService {
    /**
     *
     * @param customerDto CustomerDto Object
     */
    void create(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return boolean successful or not
     */
    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}

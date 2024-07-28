package com.shivam.accounts.service;

import com.shivam.accounts.dto.CustomerDetailsDto;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {

    /**
     *
     * @param mobileNumber
     * @return Customer Details based on given mobilenumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}

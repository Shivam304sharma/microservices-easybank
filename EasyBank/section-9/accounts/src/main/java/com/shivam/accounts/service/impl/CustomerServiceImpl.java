package com.shivam.accounts.service.impl;

import com.shivam.accounts.dto.AccountsDto;
import com.shivam.accounts.dto.CardsDto;
import com.shivam.accounts.dto.CustomerDetailsDto;
import com.shivam.accounts.dto.LoansDto;
import com.shivam.accounts.entity.Accounts;
import com.shivam.accounts.entity.Customer;
import com.shivam.accounts.exception.ResourceNotFoundException;
import com.shivam.accounts.mapper.AccountsMapper;
import com.shivam.accounts.mapper.CustomerMapper;
import com.shivam.accounts.repository.AccountsRepository;
import com.shivam.accounts.repository.CustomerRepository;
import com.shivam.accounts.service.ICustomerService;
import com.shivam.accounts.service.client.CardsFeignClient;
import com.shivam.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber , String correlationId) {
        Customer customer= customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("customer","mobileNumber",mobileNumber));
        Accounts account= accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString()));
        CustomerDetailsDto customerDetailsDto= CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account,new AccountsDto()));
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity= cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}

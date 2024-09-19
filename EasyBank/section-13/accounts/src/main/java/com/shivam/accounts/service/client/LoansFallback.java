package com.shivam.accounts.service.client;

import com.shivam.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements  LoansFeignClient{
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String correlationId, String mobileNumber) {
        LoansDto loansDto= new LoansDto();
        loansDto.setLoanType("DEFAULT_FALLBACK");
        loansDto.setLoanNumber("11111111");
        loansDto.setTotalLoan(1000000);
        loansDto.setAmountPaid(200000);
        loansDto.setMobileNumber("8445620377");
        loansDto.setOutstandingAmount(800000);
        return ResponseEntity.ok(loansDto);
    }
}

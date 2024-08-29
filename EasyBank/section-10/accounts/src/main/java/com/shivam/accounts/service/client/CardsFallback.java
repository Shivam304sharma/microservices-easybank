package com.shivam.accounts.service.client;

import com.shivam.accounts.dto.CardsDto;
import com.shivam.accounts.dto.LoansDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements  CardsFeignClient{

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        CardsDto cardsDto= new CardsDto();
        cardsDto.setCardNumber("11111111");
        cardsDto.setCardType("Default Fallback Response");
        cardsDto.setAmountUsed(60000);
        cardsDto.setTotalLimit(100000);
        cardsDto.setMobileNumber("8445620377");
        cardsDto.setAvailableAmount(94000);
        return ResponseEntity.ok(cardsDto);
    }
}

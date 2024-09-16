package com.shivam.accounts.controller;

import com.shivam.accounts.dto.CustomerDetailsDto;
import com.shivam.accounts.dto.ErrorResponseDto;
import com.shivam.accounts.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Tag(
        name = "REST APIs for CustpomerEazyBank",
        description = "REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE Customer details"
)
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})

public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    public final ICustomerService customerService;
    public CustomerController(ICustomerService customerService){
        this.customerService=customerService;
    }
    @Operation(
            summary = "Fetch Customer Details REST API",
            description = "REST API to fetch Customer &  Account , Loan, Cards details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestHeader("eazybank-correlation-id") String correlationId,
                                                                   @RequestParam
                                                                   @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
                                                                   String mobileNumber){
        logger.debug("Eazybank-correlation-id found:{}",correlationId);
        CustomerDetailsDto customerDetailsDto= customerService.fetchCustomerDetails(mobileNumber,correlationId);
        return ResponseEntity.ok(customerDetailsDto);

    }
}

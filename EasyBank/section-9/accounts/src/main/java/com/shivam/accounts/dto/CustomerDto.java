package com.shivam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
@Schema(name = "customer",
    description = "Schema to hold customer and account information"
)
public class CustomerDto {

    @Schema(description = "name of the customer", example = "Shivam Sharma")
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min =5,max = 30,message = "The customer name should be between 5 and 30")
    private String name;

    @Schema(description = "Email of the customer", example = "shivam007mrt@gmail.com")
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email Address should be valid.")
    private String email;

    @Schema(description = "Mobile Number of the customer", example = "8445620377")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Account Details of the customer")
    private AccountsDto accountsDto;
}

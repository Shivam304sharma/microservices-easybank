package com.shivam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name="Account",description = "Schema to hold Account Information.")
public class AccountsDto {

    @Schema(description = "Account number of EazyBank Account", example = "3454433243")
    @NotEmpty(message = "Account Number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account Number must be 10 digits")
    private Long accountNumber;

    @Schema(description = "Type of EazyBank Account", example = "Savings")
    @NotEmpty(message ="Account type cannot be null or empty")
    private String accountType;

    @Schema(description = "EazyBank Branch Address",example = "123 New York")
    @NotEmpty(message ="Account type cannot be null or empty")
    private String branchAddress;

}

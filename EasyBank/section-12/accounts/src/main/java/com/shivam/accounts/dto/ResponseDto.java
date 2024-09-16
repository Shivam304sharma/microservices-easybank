package com.shivam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@Schema(name = "Response",
    description = "Schema to hold response Information"
)
public class ResponseDto {

    @Schema(description = "status code in the response.")
    private String statusCode;

    @Schema(description = "status message in the response")
    private String statusMessage;
}

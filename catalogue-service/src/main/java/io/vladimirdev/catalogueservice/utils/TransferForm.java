package io.vladimirdev.catalogueservice.utils;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

@Data
public class TransferForm {
    @NotNull(message = "Recipient ID cannot be null")
    private Integer id;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount must be greater than 0")
    private Integer sum;
}

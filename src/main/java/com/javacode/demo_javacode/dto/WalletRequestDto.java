package com.javacode.demo_javacode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Vladislav Azamat
 *
 */
@Schema(description = "Запрос клиента")
public record WalletRequestDto(

        @Schema(description = "Номер счета")
        @JsonProperty("walletId")
        @NotNull(message = "Номер счета не должен быть null")
        UUID id,

        @Schema(description = "Вид операции")
        @NotNull(message = "Вид операции не должна быть null")
        OperationTypeDto operationType,

        @Schema(description = "Сумма счета")
        @NotNull(message = "Сумма счета не должна быть null")
        @Digits(integer = 19, fraction = 2, message = "Сумма счета должна содержать не более 19 цифр в целой части и 2 знаков после запятой")
        BigDecimal amount

    ){
}

package com.javacode.demo_javacode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.UUID;

public record WalletResponseDto(

        @Schema(description = "Номер счета")
        UUID walletId,

        @Schema(description = "Сумма счета")
        BigDecimal amount
) {

}

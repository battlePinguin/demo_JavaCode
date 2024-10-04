package dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Azamat Vladislav
 *
 */
@Schema(description = "Ответное сообщение системы в случае ошибки")
public record WalletDto(

    @Schema(description = "Номер счета")
    UUID id,

    @Schema(description = "Вид операции")
    OperationTypeDto operationType,

    @Schema(description = "Сумма счета")
    BigDecimal amount

    ){
}

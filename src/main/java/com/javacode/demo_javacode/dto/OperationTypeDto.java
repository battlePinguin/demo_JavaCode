package dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Azamat Vladislav
 */
@Schema(description = "Платежные системы")
public enum OperationTypeDto {
    /**
     * Система Мир.
     */
    DEPOSIT,
    /**
     * Система MasterCard.
     */
    WITHDRAW
}

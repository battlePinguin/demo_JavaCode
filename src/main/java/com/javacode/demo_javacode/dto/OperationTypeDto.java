package com.javacode.demo_javacode.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    WITHDRAW;

    @JsonCreator
    public static OperationTypeDto fromClient(String jsonValue) {
        for (OperationTypeDto type : OperationTypeDto.values()) {
            if (type.name().equalsIgnoreCase(jsonValue)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Недопустимое значение для OperationTypeDto: " + jsonValue);
    }

}

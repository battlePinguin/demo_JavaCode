package com.javacode.demo_javacode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 * @author Vladislav Azamat
 */
@Schema(description = "Ответное сообщение системы в случае ошибки")
public record ErrorDto(

        @Schema(description = "Код ошибки")
        int errorCode,

        @Schema(description = "Наименование ошибки")
        String errorMessage,

        @Schema(description = "Время возникновения ошибки")
        LocalDateTime timestamp
) {
}

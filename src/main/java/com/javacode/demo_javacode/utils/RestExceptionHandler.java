package com.javacode.demo_javacode.utils;

import com.javacode.demo_javacode.dto.ErrorDto;
import com.javacode.demo_javacode.utils.exception.InsufficientFundsException;
import com.javacode.demo_javacode.utils.exception.WalletNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

/**
 * Глобальный обработчик ошибок.
 *
 * @author Vladislav Azamat
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /**
     * Обработчик ошибок со статусом 404 NOT FOUND.
     *
     * @param ex Объект исключения.
     * @return Информацию об ошибке.
     */
    @ExceptionHandler(WalletNotFoundException.class)
    public ErrorDto handleWalletNotFoundException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return getErrorDto(HttpStatus.NOT_FOUND);
    }

    /**
     * Обработчик ошибок со статусом 400 BAD REQUEST.
     *
     * @param ex Объект исключения.
     * @return Информацию об ошибке.
     */
    @ExceptionHandler({InsufficientFundsException.class,
            MethodArgumentNotValidException.class,
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class})
    public ErrorDto handleInsufficientFundsException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return getErrorDto(HttpStatus.BAD_REQUEST);
    }

    /**
     * Обработчик ошибок со статусом 500 INTERNAL_SERVER_ERROR.
     *
     * @param ex Объект исключения.
     * @return Информацию об ошибке.
     */
    @ExceptionHandler(Exception.class)
    public ErrorDto handleGeneralException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return getErrorDto(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Создает объект для заданного HTTP статуса.
     *
     * @param httpStatus HTTP статус
     * @return response-объект сообщения об ошибке
     */
    private ErrorDto getErrorDto(HttpStatus httpStatus) {
        return new ErrorDto(httpStatus.value(), httpStatus.getReasonPhrase().toUpperCase(), LocalDateTime.now());
    }
}
package com.javacode.demo_javacode.utils.exception;

/**
 * Исключение, указывающее на недостаток средств на счете.
 * Код ошибки: 404.
 *
 * @author Vladislav Azamat
 */
public class InsufficientFundsException extends RuntimeException {

    /**
     * Конструктор исключения.
     *
     * @param message Сообщение.
     */
    public InsufficientFundsException(final String message) {super(message);}
}

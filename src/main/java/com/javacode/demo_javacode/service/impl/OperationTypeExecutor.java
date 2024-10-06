package com.javacode.demo_javacode.service.impl;

import com.javacode.demo_javacode.entity.Wallet;
import com.javacode.demo_javacode.service.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@Service
public class OperationTypeExecutor {

    private final Map<String, OperationType> operations;

    @Autowired
    public OperationTypeExecutor(Map<String, OperationType> operations) {
        this.operations = operations;
    }

    public Wallet executeOperation(String operation, WalletService walletService, UUID id, BigDecimal amount) {
        OperationType operationType = operations.get(operation.toUpperCase());
        if (operationType == null) {
            throw new IllegalArgumentException("Invalid operation type: " + operation);
        }
        return operationType.execute(walletService, id, amount);
    }
}
package com.javacode.demo_javacode.service.impl;

import com.javacode.demo_javacode.entity.Wallet;
import com.javacode.demo_javacode.service.OperationType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component("DEPOSIT")
public class DepositOperation implements OperationType {
    @Override
    public Wallet execute(WalletService walletService, UUID id, BigDecimal amount) {
        return walletService.depositToAccount(id, amount);
    }
}

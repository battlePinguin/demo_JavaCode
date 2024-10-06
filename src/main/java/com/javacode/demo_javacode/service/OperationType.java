package com.javacode.demo_javacode.service;

import com.javacode.demo_javacode.entity.Wallet;
import com.javacode.demo_javacode.service.impl.WalletService;

import java.math.BigDecimal;
import java.util.UUID;

public interface OperationType {
    Wallet execute(WalletService walletService, UUID id, BigDecimal amount);
}

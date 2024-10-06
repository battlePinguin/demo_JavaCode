package com.javacode.demo_javacode.service.impl;

import com.javacode.demo_javacode.dto.WalletResponseDto;
import com.javacode.demo_javacode.service.OperationType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component("WITHDRAW")
public class WithdrawOperation implements OperationType {

    @Override
    public WalletResponseDto execute(WalletService walletService, UUID id, BigDecimal amount) {
        return walletService.withdrawFromAccount(id, amount);
    }
}

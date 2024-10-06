package com.javacode.demo_javacode.controller;

import com.javacode.demo_javacode.dto.WalletRequestDto;
import com.javacode.demo_javacode.dto.WalletResponseDto;
import com.javacode.demo_javacode.service.impl.OperationTypeExecutor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.javacode.demo_javacode.service.impl.WalletService;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/wallets")
public class WalletController {

    private final OperationTypeExecutor operationExecutor;
    private final WalletService walletService;

    public WalletController(OperationTypeExecutor operationExecutor, WalletService walletService) {
        this.operationExecutor = operationExecutor;
        this.walletService = walletService;
    }

    @PostMapping
    public WalletResponseDto handleOperation(@Valid @RequestBody WalletRequestDto request) {
        return operationExecutor.executeOperation(request.operationType().toString(), walletService, request.id(), request.amount());
    }

    @GetMapping("/{walletId}")
    public WalletResponseDto getWalletBalance(@PathVariable UUID walletId) {
        return walletService.getAmount(walletId);
    }
}

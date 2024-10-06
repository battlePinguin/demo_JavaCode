package com.javacode.demo_javacode.controller;

import com.javacode.demo_javacode.dto.WalletDto;
import com.javacode.demo_javacode.entity.Wallet;
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
//
//    @PostMapping
//    public Wallet handleOperation(@Valid @RequestBody WalletDto request) throws Exception {
//        log.info(request.id() + "");
//        switch (request.operationType().toString()) {
//            case "DEPOSIT":
//                return walletService.depositToAccount(request.id(), request.amount());
//            case "WITHDRAW":
//                return walletService.withdrawFromAccount(request.id(), request.amount());
//            default:
//                throw new Exception("Невалидный оператор");
//        }
//    }
    @PostMapping
    public Wallet handleOperation(@Valid @RequestBody WalletDto request) {
        return operationExecutor.executeOperation(request.operationType().toString(), walletService, request.id(), request.amount());
    }

    @GetMapping("/{walletId}")
    public Wallet getWalletBalance(@PathVariable UUID walletId) {
        return walletService.getAmount(walletId);
    }
}

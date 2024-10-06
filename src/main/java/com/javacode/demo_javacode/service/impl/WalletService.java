package com.javacode.demo_javacode.service.impl;

import com.javacode.demo_javacode.entity.Wallet;
import jakarta.transaction.Transactional;
import com.javacode.demo_javacode.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Slf4j
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Wallet depositToAccount(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Такого счета не обнаружено!"));
        wallet.setAmount(wallet.getAmount().add(amount));
        return walletRepository.save(wallet);
    }

    @Transactional
    public Wallet withdrawFromAccount(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Такого счета не обнаружено!"));
        if (wallet.getAmount().compareTo(amount) < 0 ) {
            throw new RuntimeException("Недостаточно средств для проведения транзакции!");
        }
        wallet.setAmount(wallet.getAmount().subtract(amount));
        return walletRepository.save(wallet);
    }

    @Transactional()
    public Wallet getAmount(UUID walletId) {
        log.info(walletId.toString());
        return walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException(String.format("Card with id: %s was not found", walletId)));
    }
    
}

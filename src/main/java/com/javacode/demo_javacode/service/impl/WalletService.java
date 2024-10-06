package com.javacode.demo_javacode.service.impl;

import com.javacode.demo_javacode.dto.WalletResponseDto;
import com.javacode.demo_javacode.entity.Wallet;
import com.javacode.demo_javacode.mapper.WalletMapper;
import com.javacode.demo_javacode.utils.exception.WalletNotFoundException;
import jakarta.persistence.EntityManager;
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
    private final WalletMapper walletMapper;

    public WalletService(WalletRepository walletRepository, WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    @Transactional
    public WalletResponseDto depositToAccount(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findByIdWithWriteLock(walletId).orElseThrow(() -> new WalletNotFoundException("Такого счета не обнаружено!"));
        wallet.setAmount(wallet.getAmount().add(amount));
        return walletMapper.toWalletResponseDto(walletRepository.save(wallet));
    }

    @Transactional
    public WalletResponseDto withdrawFromAccount(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findByIdWithWriteLock(walletId).orElseThrow(() -> new WalletNotFoundException("Такого счета не обнаружено!"));
        if (wallet.getAmount().compareTo(amount) < 0 ) {
            throw new RuntimeException("Недостаточно средств для проведения транзакции!");
        }
        wallet.setAmount(wallet.getAmount().subtract(amount));
        return walletMapper.toWalletResponseDto(walletRepository.save(wallet));
    }

    @Transactional()
    public WalletResponseDto getAmount(UUID walletId) {
        log.info(walletId.toString());
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException(String.format("Card with id: %s was not found", walletId)));
        return walletMapper.toWalletResponseDto(walletRepository.save(wallet));
    }
    
}

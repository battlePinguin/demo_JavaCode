package service;

import entity.Wallet;
import jakarta.transaction.Transactional;
import repository.WalletRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
    @Transactional
    public Wallet deposit(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Такого счета не обнаружено!"));
        wallet.setAmount(wallet.getAmount().add(amount));
        return walletRepository.save(wallet);
    }

    @Transactional
    public Wallet withdraw(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Такого счета не обнаружено!"));
        if (wallet.getAmount().compareTo(amount) < 0 ) {
            throw new RuntimeException("Недостаточно средств для проведения транзакции!");
        }
        wallet.setAmount(wallet.getAmount().subtract(amount));
        return walletRepository.save(wallet);
    }

    public Wallet getAmount(UUID walletId) {
        return walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Такого счета не обнаружено!"));
    }
    
}

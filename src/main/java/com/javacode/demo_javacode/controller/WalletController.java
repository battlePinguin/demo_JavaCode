package controller;

import dto.WalletDto;
import entity.Wallet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.WalletService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet handleOperation(@RequestBody WalletDto request) {
        switch (request.operationType().toString()) {
            case "DEPOSIT":
                return walletService.deposit(request.id(), request.amount());
            case "WITHDRAW":
                return walletService.withdraw(request.id(), request.amount());
            default:
                throw new RuntimeException("Invalid operation type");
        }
    }

    @GetMapping("/{walletId}")
    public Wallet getWalletBalance(@PathVariable UUID walletId) {
        return walletService.getAmount(walletId);
    }
}

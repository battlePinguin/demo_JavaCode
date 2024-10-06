package com.javacode.demo_javacode.repository;

import com.javacode.demo_javacode.entity.Wallet;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @QueryHints({ @QueryHint(name = "javax.persistence.lock.timeout", value = "5000") })
    @Query(value = "SELECT * FROM wallet WHERE id = :walletId FOR UPDATE", nativeQuery = true)
    Optional<Wallet> findByIdWithWriteLock(UUID walletId);
}

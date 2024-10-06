package com.javacode.demo_javacode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal amount;

    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

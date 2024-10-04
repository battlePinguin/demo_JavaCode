package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "wallet")
public class Wallet {
    
    @Id
    UUID id;

    BigDecimal amount;

    // TODO: перенести проверку в ДТОху
    public void setBalance(BigDecimal amount) {

        if (amount.precision() - amount.scale() > 17) { // Проверка на общее количество цифр до запятой
            throw new IllegalArgumentException("Общее количество цифр перед запятой не должно превышать 17");
        }
        this.amount = amount.setScale(2, RoundingMode.HALF_UP); // Устанавливаем 2 знака после запятой
    }

}

package dev.marvin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tbl_wallets")
@Data
public class Wallet {
    @Id
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private BigDecimal balance = BigDecimal.ZERO;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    private Boolean isDeleted;
    private Set<Transaction> transactions;
}

package dev.marvin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tbl_wallets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id
    private String phoneNumber;
    private String fullName;
    private BigDecimal balance = BigDecimal.ZERO;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    private Boolean isDeleted;

    @OneToMany
    private Set<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

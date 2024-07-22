package dev.marvin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_transactions")
@Data
public class Transaction {
    @Id
    private String transactionCode;
    private TransactionType transactionType;
    private BigDecimal amount;
    @CreationTimestamp
    private LocalDateTime createdDate;
}

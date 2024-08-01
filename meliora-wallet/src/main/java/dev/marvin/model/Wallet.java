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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number", unique = true, length = 12)
    private String phoneNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "balance")
    private BigDecimal balance;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany
    private Set<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

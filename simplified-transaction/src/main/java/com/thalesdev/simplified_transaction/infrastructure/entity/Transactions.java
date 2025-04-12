package com.thalesdev.simplified_transaction.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactions")
@Table
@Builder
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;

    @JoinColumn(name = "payee_id")
    @ManyToOne
    private Users payee;

    @JoinColumn(name = "payer_id")
    @ManyToOne
    private Users payer;

    private LocalDateTime transactionDateTime;

    @PrePersist
    void prePersist(){
        transactionDateTime = LocalDateTime.now();
    }
}

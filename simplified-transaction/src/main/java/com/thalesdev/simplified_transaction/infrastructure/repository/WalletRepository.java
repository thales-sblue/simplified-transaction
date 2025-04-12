package com.thalesdev.simplified_transaction.infrastructure.repository;

import com.thalesdev.simplified_transaction.infrastructure.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}

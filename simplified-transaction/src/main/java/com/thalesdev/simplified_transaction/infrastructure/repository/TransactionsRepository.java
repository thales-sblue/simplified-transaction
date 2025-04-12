package com.thalesdev.simplified_transaction.infrastructure.repository;

import com.thalesdev.simplified_transaction.infrastructure.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}

package com.thalesdev.simplified_transaction.infrastructure.repository;

import com.thalesdev.simplified_transaction.infrastructure.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}

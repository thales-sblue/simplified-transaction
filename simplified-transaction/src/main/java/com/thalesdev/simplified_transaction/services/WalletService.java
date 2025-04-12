package com.thalesdev.simplified_transaction.services;

import com.thalesdev.simplified_transaction.infrastructure.entity.Wallet;
import com.thalesdev.simplified_transaction.infrastructure.repository.UserRepository;
import com.thalesdev.simplified_transaction.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    public void save(Wallet wallet){
        walletRepository.save(wallet);
    }
}

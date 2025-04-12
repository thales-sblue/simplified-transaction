package com.thalesdev.simplified_transaction.services;

import com.thalesdev.simplified_transaction.infrastructure.clients.ClientAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final ClientAuth clientAuth;

    public boolean validateTransfer() {
        return Boolean.parseBoolean(clientAuth.validateAuthorization().data().authorization());
    }
}

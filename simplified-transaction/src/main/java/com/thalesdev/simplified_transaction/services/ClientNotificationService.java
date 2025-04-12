package com.thalesdev.simplified_transaction.services;

import com.thalesdev.simplified_transaction.infrastructure.clients.ClientNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientNotificationService {

    private final ClientNotification clientNotification;

    public void sendNotification(){
        clientNotification.sendNotification();
    }
}

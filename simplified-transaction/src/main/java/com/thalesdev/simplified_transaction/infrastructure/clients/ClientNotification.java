package com.thalesdev.simplified_transaction.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${client.notification.url}", name = "notification")
public interface ClientNotification {

    @PostMapping
    void sendNotification();
}

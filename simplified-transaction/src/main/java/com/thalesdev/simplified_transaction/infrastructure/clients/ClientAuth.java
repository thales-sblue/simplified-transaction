package com.thalesdev.simplified_transaction.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${client.auth.url}", name = "Authorization")
public interface ClientAuth {

    @GetMapping
    ClientAuthDTO validateAuthorization();
}

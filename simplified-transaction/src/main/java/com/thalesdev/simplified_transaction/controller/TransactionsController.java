package com.thalesdev.simplified_transaction.controller;

import com.thalesdev.simplified_transaction.services.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransactionsController {

    private final TransactionsService transactionsService;

    @PostMapping
    public ResponseEntity<Void> executeTransaction(@RequestBody TransactionsDTO transactionsDTO){
        transactionsService.transferValues(transactionsDTO);
        return ResponseEntity.accepted().build();
    }
}

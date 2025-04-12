package com.thalesdev.simplified_transaction.services;

import com.thalesdev.simplified_transaction.controller.TransactionsDTO;
import com.thalesdev.simplified_transaction.infrastructure.entity.Transactions;
import com.thalesdev.simplified_transaction.infrastructure.entity.Users;
import com.thalesdev.simplified_transaction.infrastructure.entity.UserType;
import com.thalesdev.simplified_transaction.infrastructure.entity.Wallet;
import com.thalesdev.simplified_transaction.infrastructure.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionsService {

    private final UserService userService;
    private final AuthorizationService authorizationService;
    private final WalletService walletService;
    private final TransactionsRepository transactionsRepository;
    private final ClientNotificationService clientNotificationService;

    @Transactional
    public void transferValues(TransactionsDTO transactionDTO){
        Users payer = userService.findUser(transactionDTO.payer());
        Users payee = userService.findUser(transactionDTO.payee());

        validatePayerIsNotMerchant(payer);
        validateUserHasSufficientBalance(payer, transactionDTO.value());
        validateTransfer();

        payer.getWallet().setBalance(payer.getWallet().getBalance().subtract(transactionDTO.value()));
        updateWalletBalance(payer.getWallet());

        payee.getWallet().setBalance(payee.getWallet().getBalance().add(transactionDTO.value()));
        updateWalletBalance(payee.getWallet());

        Transactions transactions = Transactions.builder()
                .value(transactionDTO.value())
                .payer(payer)
                .payee(payee)
                .build();

        transactionsRepository.save(transactions);
        sendNotification();
    }

    private void validatePayerIsNotMerchant(Users users) {
        if (users.getUserType() == UserType.MERCHANT) {
            throw new IllegalArgumentException("Transaction not authorized for this user type");
        }
    }

    private void validateUserHasSufficientBalance(Users users, BigDecimal value) {
        if (users.getWallet().getBalance().compareTo(value) < 0) {
            throw new IllegalArgumentException("Transaction not authorized: insufficient balance");
        }
    }

    private void validateTransfer(){
        if(!authorizationService.validateTransfer()){
            throw new IllegalStateException("Transaction not authorized");
        }
    }

    private void updateWalletBalance(Wallet wallet){
        walletService.save(wallet);
    }

    private void sendNotification() {
        try {
            clientNotificationService.sendNotification();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to send notification");
        }
    }
}

package com.thalesdev.simplified_transaction.controller;

import java.math.BigDecimal;

public record TransactionsDTO(BigDecimal value, long payer, long payee) {
}

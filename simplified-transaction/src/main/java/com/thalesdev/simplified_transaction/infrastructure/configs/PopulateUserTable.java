package com.thalesdev.simplified_transaction.infrastructure.configs;

import com.thalesdev.simplified_transaction.infrastructure.entity.Users;
import com.thalesdev.simplified_transaction.infrastructure.entity.Wallet;
import com.thalesdev.simplified_transaction.infrastructure.entity.UserType;
import com.thalesdev.simplified_transaction.infrastructure.repository.WalletRepository;
import com.thalesdev.simplified_transaction.infrastructure.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class PopulateUserTable {
    @Bean
    CommandLineRunner popularBanco(UserRepository userRepository, WalletRepository walletRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

                Users users1 = new Users(null, "Carlos Silva", "carlos@email.com", "101111111111",
                        encoder.encode("123456"), null, UserType.COMMOM);

                Users users2 = new Users(null, "Ana Souza", "ana@email.com", "22222222222",
                        encoder.encode("123456"), null, UserType.COMMOM);

                Users merchant = new Users(null, "Loja Exemplo", "loja@email.com", "33333333333",
                        encoder.encode("123456"), null, UserType.MERCHANT);

                userRepository.saveAll(List.of(users1, users2, merchant));


                Wallet wallet1 = new Wallet(null, new BigDecimal("1000.00"), users1);
                Wallet wallet2 = new Wallet(null, new BigDecimal("2000.00"), users2);
                Wallet wallet3 = new Wallet(null, new BigDecimal("5000.00"), merchant);

                walletRepository.saveAll(List.of(wallet1, wallet2, wallet3));

                System.out.println("Users and wallets created!");
            }
        };
    }
}
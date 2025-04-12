package com.thalesdev.simplified_transaction.services;

import com.thalesdev.simplified_transaction.infrastructure.entity.Users;
import com.thalesdev.simplified_transaction.infrastructure.exceptions.UserNotFound;
import com.thalesdev.simplified_transaction.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users findUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->
                        new UserNotFound("User not found!"));
    }
}

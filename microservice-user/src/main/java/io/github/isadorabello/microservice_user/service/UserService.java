package io.github.isadorabello.microservice_user.service;

import io.github.isadorabello.microservice_user.model.UserModel;
import io.github.isadorabello.microservice_user.producer.UserProducer;
import io.github.isadorabello.microservice_user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer producer;

    public UserService(UserRepository userRepository, UserProducer producer) {
        this.userRepository = userRepository;
        this.producer = producer;
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        // da errado colocar não atribuir o retorno do repositorio para a variavel?
        userModel = userRepository.save(userModel);
        producer.publishMessageEmail(userModel);
        return userModel;
    }
}

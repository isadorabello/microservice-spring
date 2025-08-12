package io.github.isadorabello.microservice_spring.service;

import io.github.isadorabello.microservice_spring.model.User;
import io.github.isadorabello.microservice_spring.producer.UserProducer;
import io.github.isadorabello.microservice_spring.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository repository;
    final UserProducer producer;

    public UserService(UserRepository userRepository, UserProducer producer) {
        this.repository = userRepository;
        this.producer = producer;
    }

    @Transactional
    public User save(User userModel) {
        // da errado colocar não atribuir o retorno do repositorio para a variavel?
        userModel = repository.save(userModel);
        producer.publishMessageEmail(userModel);
        return userModel;
    }
}

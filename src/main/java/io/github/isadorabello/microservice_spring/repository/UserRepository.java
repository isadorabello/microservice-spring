package io.github.isadorabello.microservice_spring.repository;

import io.github.isadorabello.microservice_spring.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}

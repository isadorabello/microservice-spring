package io.github.isadorabello.microservice_spring.repository;

import io.github.isadorabello.microservice_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

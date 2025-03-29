package io.github.isadorabello.microservice_user.repository;

import io.github.isadorabello.microservice_user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}

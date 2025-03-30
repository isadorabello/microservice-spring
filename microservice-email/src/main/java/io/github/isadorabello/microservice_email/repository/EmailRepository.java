package io.github.isadorabello.microservice_email.repository;

import io.github.isadorabello.microservice_email.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}

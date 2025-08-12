package io.github.isadorabello.microservice_spring.dto;

import java.util.UUID;

public record EmailDTO(UUID id, String email, String subject, String text) {
}

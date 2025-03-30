package io.github.isadorabello.microservice_email.dto;

import java.util.UUID;

public record EmailRecordDTO(UUID id, String email, String subject, String text) {
}

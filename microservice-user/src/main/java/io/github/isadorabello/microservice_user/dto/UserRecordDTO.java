package io.github.isadorabello.microservice_user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String name,
                            @NotBlank @Email String email ) {
}

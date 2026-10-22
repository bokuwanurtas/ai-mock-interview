package com.aimockinterview.backend.dto;
import jakarta.validation.constraints.*;
import java.util.UUID;
public record InterviewRequest(@NotNull UUID userId, Integer companyId,
 @NotNull Integer specializationId, @NotBlank String level, @NotBlank String mode) {}

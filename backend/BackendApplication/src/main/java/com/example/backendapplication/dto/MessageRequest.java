package com.aimockinterview.backend.dto;
import jakarta.validation.constraints.*;
public record MessageRequest(@NotBlank String role, @NotBlank String content) {}

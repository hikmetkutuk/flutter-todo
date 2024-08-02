package com.todo.dto;

import jakarta.validation.constraints.NotNull;

public record TaskRequest(
        @NotNull(message = "Title is required")
        String title
) {
}

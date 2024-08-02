package com.todo.dto;

public record TaskResponse(
        Long id,
        String title,
        boolean done
) {
}

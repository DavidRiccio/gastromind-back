package com.gastromind.api.infrastructure.adapters.in.rest.handler;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String message, LocalDateTime timestamp) {}
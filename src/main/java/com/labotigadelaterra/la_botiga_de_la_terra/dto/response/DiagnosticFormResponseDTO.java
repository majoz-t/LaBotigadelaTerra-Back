package com.labotigadelaterra.la_botiga_de_la_terra.dto.response;

import java.time.LocalDateTime;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.FormStatus;

public record DiagnosticFormResponseDTO(
    Integer id,
    Integer age,
    FormStatus formStatus,
    LocalDateTime submittedAt
) {}

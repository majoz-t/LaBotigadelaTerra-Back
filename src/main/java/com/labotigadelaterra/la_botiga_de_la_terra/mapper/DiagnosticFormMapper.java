package com.labotigadelaterra.la_botiga_de_la_terra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.DiagnosticFormRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.dto.response.DiagnosticFormResponseDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.DiagnosticForm;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;

@Mapper(componentModel = "spring")
public interface DiagnosticFormMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "formStatus", ignore = true)
    @Mapping(target = "submittedAt", ignore = true)
    DiagnosticForm toEntity(DiagnosticFormRequestDTO request, User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "formStatus", ignore = true)
    @Mapping(target = "submittedAt", ignore = true)
    void updateEntityFromDto(DiagnosticFormRequestDTO request, @MappingTarget DiagnosticForm form);

    DiagnosticFormResponseDTO toResponse(DiagnosticForm form);
}

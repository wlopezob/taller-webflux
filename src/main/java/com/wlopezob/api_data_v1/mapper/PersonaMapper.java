package com.wlopezob.api_data_v1.mapper;

import org.mapstruct.Mapper;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.entity.PersonaEntity;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaEntity toEntity(PersonaRequest personaRequest);
    PersonaResponse toResponse(PersonaEntity personaEntity);
}

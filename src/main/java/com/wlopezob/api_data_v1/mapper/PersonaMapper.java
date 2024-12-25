package com.wlopezob.api_data_v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.enitity.PersonaEntity;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    @Mapping(target = "fechaNacimiento", expression = "java(com.wlopezob.api_data_v1.util.Util.stringToDate(personaRequest.getFechaNacimiento()))")
    PersonaEntity toEntity(PersonaRequest personaRequest);

    @Mapping(target = "fechaNacimiento", expression = "java(com.wlopezob.api_data_v1.util.Util.dateToString(personaEntity.getFechaNacimiento()))")
    PersonaResponse toResponse(PersonaEntity personaEntity);
}


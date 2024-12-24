package com.wlopezob.api_data_v1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.repository.PersonaRepository;
import com.wlopezob.api_data_v1.service.PersonaService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<PersonaResponse> getAll() {
       return personaRepository.findAll().stream().map(persona -> PersonaResponse.builder()
               .id(persona.getId())
               .nombre(persona.getNombre())
               .apellido(persona.getApellido())
               .edad(persona.getEdad())
               .fechaNacimiento(persona.getFechaNacimiento())
               .build()).collect(Collectors.toList());
    }
    
}

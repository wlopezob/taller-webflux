package com.wlopezob.api_data_v1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.entity.PersonaEntity;
import com.wlopezob.api_data_v1.repository.PersonaRepository;
import com.wlopezob.api_data_v1.service.PersonaService;
import com.wlopezob.api_data_v1.util.Util;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<PersonaResponse> getAll() {
       return personaRepository.findAll().stream()
                .map(persona -> PersonaResponse.builder()
                    .id(persona.getId())
                    .documento(persona.getDocumento())
                    .nombre(persona.getNombre())
                    .apellido(persona.getApellido())
                    .edad(persona.getEdad())
                    .fechaNacimiento(persona.getFechaNacimiento())
                    .build())
                .collect(Collectors.toList());
    }

    @Override
    public Flux<PersonaResponse> getAllReactive() {
        var personRespone = personaRepository.findAll().stream()
                .map(persona -> PersonaResponse.builder()
                    .documento(persona.getDocumento())
                    .id(persona.getId())
                    .nombre(persona.getNombre())
                    .apellido(persona.getApellido())
                    .edad(persona.getEdad())
                    .fechaNacimiento(persona.getFechaNacimiento())
                    .build())
                .collect(Collectors.toList());
        return Flux.fromIterable(personRespone);
    }

    @Override
    public PersonaResponse getById(Long id) {
        var personaResponse = personaRepository.findById(id)
            .map(persona -> PersonaResponse.builder()
                .id(persona.getId())
                .documento(persona.getDocumento())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .edad(persona.getEdad())
                .fechaNacimiento(persona.getFechaNacimiento())
                .build())
            .orElse(null);
        return personaResponse;        
    }

    @Override
    public Mono<PersonaResponse> getByIdReactive(Long id) {
        return personaRepository.findById(id)
            .map(persona -> PersonaResponse.builder()
                .id(persona.getId())
                .documento(persona.getDocumento())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .edad(persona.getEdad())
                .fechaNacimiento(persona.getFechaNacimiento())
                .build())
            .map(Mono::just)
            .orElseGet(Mono::empty);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteReactive(Long id) {
        return Mono.fromRunnable(() -> personaRepository.deleteById(id));
    }

    @Override
    public Mono<PersonaResponse> save(PersonaRequest personaRequest) {
        return Mono.just(personaRequest)
            .map(persona -> PersonaEntity.builder()
                .documento(persona.getDocumento())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .edad(persona.getEdad())
                .fechaNacimiento(Util.convertStringToDate(persona.getFechaNacimiento()))
                .build())
            .map(personaEntity -> personaRepository.save(personaEntity))
            .map(personaEntity -> PersonaResponse.builder()
                .id(personaEntity.getId())
                .documento(personaEntity.getDocumento())
                .nombre(personaEntity.getNombre())
                .apellido(personaEntity.getApellido())
                .edad(personaEntity.getEdad())
                .fechaNacimiento(personaEntity.getFechaNacimiento())
                .build());
    }
    
}

package com.wlopezob.api_data_v1.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wlopezob.api_data_v1.mapper.PersonaMapper;
import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.enitity.PersonaEntity;
import com.wlopezob.api_data_v1.repository.PersonaRepository;
import com.wlopezob.api_data_v1.services.PersonaService;
import com.wlopezob.api_data_v1.util.Util;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public Flux<PersonaResponse> getAll() {
        var personas = personaRepository.findAll()
            .stream().map(p -> personaMapper.toResponse(p))
            .collect(Collectors.toList());
        return Flux.fromIterable(personas);   
    }

    @Override
    public Mono<List<PersonaEntity>> findAllReactive() {
        List<PersonaEntity> personas = personaRepository.findAll();
        return Mono.just(personas);
    }

    @Override
    public Flux<PersonaEntity> findAllReactiveFlux() {
        return Flux.fromIterable(personaRepository.findAll());
    }

    @Override
    public Mono<PersonaResponse> findById(Long id) {
        var persona = personaRepository.findById(id)
            .map(personaMapper::toResponse)
            .map(Mono::just)
            .orElse(Mono.empty());
        return persona;
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return Mono.fromRunnable(() -> personaRepository.deleteById(id)) ;
    }

    @Override
    public Mono<PersonaResponse> save(PersonaRequest personaRequest) {
        var persona = personaMapper.toEntity(personaRequest);
        personaRepository.save(persona);
        return Mono.just(personaMapper.toResponse(persona));
    }

    @Override
    public Mono<PersonaResponse> update(Long id, PersonaRequest personaRequest) {
        var persona = personaRepository.findById(id)
            .map(p -> {
                p.setDocumento(personaRequest.getDocumento());
                p.setNombre(personaRequest.getNombre());
                p.setApellido(personaRequest.getApellido());
                p.setEdad(personaRequest.getEdad());
                p.setFechaNacimiento(Util.stringToDate(personaRequest.getFechaNacimiento()));
                return personaRepository.save(p);
            })
            .orElseThrow(() -> new RuntimeException("Persona not found"));
        return Mono.just(personaMapper.toResponse(persona));
    }

}

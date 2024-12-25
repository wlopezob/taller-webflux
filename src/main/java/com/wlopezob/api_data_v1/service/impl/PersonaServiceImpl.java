package com.wlopezob.api_data_v1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wlopezob.api_data_v1.mapper.PersonaMapper;
import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.repository.PersonaRepository;
import com.wlopezob.api_data_v1.service.PersonaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public List<PersonaResponse> getAll() {
       return personaRepository.findAll().stream()
            .map(personaMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public Flux<PersonaResponse> getAllReactive() {
        var personRespone = personaRepository.findAll().stream()
                .map(personaMapper::toResponse)
                .collect(Collectors.toList());
        return Flux.fromIterable(personRespone);
    }

    @Override
    public PersonaResponse getById(Long id) {
        var personaResponse = personaRepository.findById(id)
            .map(personaMapper::toResponse)
            .orElse(null);
        return personaResponse;        
    }

    @Override
    public Mono<PersonaResponse> getByIdReactive(Long id) {
        return personaRepository.findById(id)
            .map(personaMapper::toResponse)
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
            .map(personaMapper::toEntity)
            .map(personaEntity -> personaRepository.save(personaEntity))
            .map(personaMapper::toResponse);
    }
    
}

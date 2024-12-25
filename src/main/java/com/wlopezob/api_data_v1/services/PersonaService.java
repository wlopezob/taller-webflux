package com.wlopezob.api_data_v1.services;

import java.util.List;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.enitity.PersonaEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {

    List<PersonaEntity> findAll();
    Mono<List<PersonaEntity>> findAllReactive();
    Flux<PersonaEntity> findAllReactiveFlux();
    Mono<PersonaEntity> findById(Long id);
    Mono<Void> deleteById(Long id);
    Mono<PersonaResponse> save(PersonaRequest personaRequest);
}

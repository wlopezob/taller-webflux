package com.wlopezob.api_data_v1.services;

import java.util.List;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.enitity.PersonaEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {

    Flux<PersonaResponse> getAll();
    Mono<List<PersonaEntity>> findAllReactive();
    Flux<PersonaEntity> findAllReactiveFlux();
    Mono<PersonaResponse> findById(Long id);
    Mono<Void> deleteById(Long id);
    Mono<PersonaResponse> save(PersonaRequest personaRequest);
    Mono<PersonaResponse> update(Long id, PersonaRequest personaRequest);

}

package com.wlopezob.api_data_v1.service;

import java.util.List;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {
    List<PersonaResponse> getAll();
    Flux<PersonaResponse> getAllReactive();
    PersonaResponse getById(Long id);
    Mono<PersonaResponse> getByIdReactive(Long id);
    void delete(Long id);
    Mono<Void> deleteReactive(Long id);
    Mono<PersonaResponse> save(PersonaRequest personaRequest);
}

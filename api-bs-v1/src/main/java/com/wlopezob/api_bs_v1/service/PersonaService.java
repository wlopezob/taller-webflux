package com.wlopezob.api_bs_v1.service;

import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaRequest;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {

    Flux<PersonaResponse> getAllPersonas();
    Mono<PersonaResponse> save(PersonaRequest personaRequest);
    Mono<PersonaResponse> update(Long id, PersonaRequest personaRequest) ;
}

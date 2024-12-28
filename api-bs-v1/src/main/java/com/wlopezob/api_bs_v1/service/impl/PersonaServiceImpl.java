package com.wlopezob.api_bs_v1.service.impl;

import org.springframework.stereotype.Service;

import com.wlopezob.api_bs_v1.apicaller.ApiDataCaller;
import com.wlopezob.api_bs_v1.service.PersonaService;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaRequest;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    private final ApiDataCaller apiDataCaller;

    @Override
    public Flux<PersonaResponse> getAllPersonas() {
        return apiDataCaller.getAllPersonas();
    }

    @Override
    public Mono<PersonaResponse> save(PersonaRequest personaRequest) {
       return apiDataCaller.save(personaRequest);
    }

    @Override
    public Mono<PersonaResponse> update(Long id, PersonaRequest personaRequest) {
        return apiDataCaller.update(id, personaRequest);
    }

}

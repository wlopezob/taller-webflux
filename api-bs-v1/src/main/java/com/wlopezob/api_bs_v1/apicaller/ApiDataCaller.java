package com.wlopezob.api_bs_v1.apicaller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.wlopezob.api_bs_v1.config.ApplicationProperties;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaRequest;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiDataCaller {
    private final WebClient.Builder webClientBuilder;
    private final ApplicationProperties applicationProperties;

    public Flux<PersonaResponse> getAllPersonas() {
        return webClientBuilder.baseUrl(applicationProperties.getBaseUrlDataApi()).build()
            .get()
            .uri("/persona")
            .retrieve()
            .bodyToFlux(PersonaResponse.class)
            .doOnNext(persona -> log.info("Persona: {}", persona))
            .doOnComplete(() -> log.info("getAllPersonas() completed"))
            .doOnError(e -> log.error("Error in getAllPersonas()", e));
    }

    public Mono<PersonaResponse> save(PersonaRequest personaRequest) {
        return webClientBuilder.baseUrl(applicationProperties.getBaseUrlDataApi()).build()
            .post()
            .uri("/persona")
            .bodyValue(personaRequest)
            .retrieve()
            .bodyToMono(PersonaResponse.class)
            .doOnNext(persona -> log.info("Persona: {}", persona))
            .doOnSuccess(persona -> log.info("save() completed"))
            .doOnError(e -> log.error("Error in save()", e));
    }

    public Mono<PersonaResponse> update(Long id, PersonaRequest personaRequest) {
        return webClientBuilder.baseUrl(applicationProperties.getBaseUrlDataApi()).build()
            .put()
            .uri("/persona/{id}", id)
            .bodyValue(personaRequest)
            .retrieve()
            .bodyToMono(PersonaResponse.class)
            .doOnNext(persona -> log.info("Persona: {}", persona))
            .doOnSuccess(persona -> log.info("update() completed"))
            .doOnError(e -> log.error("Error in update()", e));
    }
   
}

package com.wlopezob.api_bs_v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopezob.api_bs_v1.service.PersonaService;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaRequest;
import com.wlopezob.api_bs_v1.thirdparty.data_api.model.PersonaResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    
    private final PersonaService personaService;
    @GetMapping
    public Flux<PersonaResponse> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @PostMapping
    public Mono<ResponseEntity<PersonaResponse>> save(@RequestBody PersonaRequest personaRequest) {
        return personaService.save(personaRequest)
            .map(ResponseEntity::ok);
    }
    @PutMapping("/{id}")
    public Mono<ResponseEntity<PersonaResponse>> update(@PathVariable(name = "id") Long id,
         @RequestBody PersonaRequest personaRequest) {
        return personaService.update(id, personaRequest)
            .map(ResponseEntity::ok);
    }
}

package com.wlopezob.api_data_v1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.enitity.PersonaEntity;
import com.wlopezob.api_data_v1.services.PersonaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping
    public List<PersonaEntity> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/reactive")
    public Flux<PersonaEntity> findAllReactive() {
        return personaService.findAllReactiveFlux();
    }

    @GetMapping("/{id}")
    public Mono<PersonaEntity> findById(@PathVariable(name = "id") Long id) {
        return personaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable(name = "id") Long id) {
        return personaService.deleteById(id);
    }

    @PostMapping
    public Mono<PersonaResponse> save(@RequestBody PersonaRequest personaRequest) {
        return personaService.save(personaRequest);
    }

    @PatchMapping("/{id}")
    public Mono<PersonaResponse> update(@PathVariable(name = "id") Long id, @RequestBody PersonaRequest personaRequest) {
        return personaService.update(id, personaRequest);
    }
}

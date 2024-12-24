package com.wlopezob.api_data_v1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.service.PersonaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
  
  private final PersonaService personaService;

  // @GetMapping
  // public List<PersonaResponse> list() {
  //   return personaService.getAll();
  // }

  @GetMapping
  public Flux<PersonaResponse> listReactive() {
    return personaService.getAllReactive();
  }

  // @GetMapping("/{id}")
  // public PersonaResponse getById(@PathVariable(name = "id") Long id) {
  //   return personaService.getById(id);
  // }
    

  @GetMapping("/{id}")
  public Mono<PersonaResponse> getById(@PathVariable(name = "id") Long id) {
    return personaService.getByIdReactive(id);//.defaultIfEmpty(PersonaResponse.builder().build());
  }

  // @DeleteMapping("/{id}")
  // public void delete(@PathVariable(name = "id") Long id) {
  //   personaService.delete(id);
  // }

  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable(name = "id") Long id) {
    return personaService.deleteReactive(id);
  }

  @PostMapping
  public Mono<PersonaResponse> save(@RequestBody PersonaRequest personaRequest) {
    return personaService.save(personaRequest);
  }
}


package com.wlopezob.api_data_v1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wlopezob.api_data_v1.mapper.PersonaMapper;
import com.wlopezob.api_data_v1.model.dto.PersonaRequest;
import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.model.enitity.PersonaEntity;
import com.wlopezob.api_data_v1.repository.PersonaRepository;
import com.wlopezob.api_data_v1.services.PersonaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Mono<List<PersonaEntity>> findAllReactive() {
        List<PersonaEntity> personas = personaRepository.findAll();
        return Mono.just(personas);
    }

    @Override
    public Flux<PersonaEntity> findAllReactiveFlux() {
        return Flux.fromIterable(personaRepository.findAll());
    }

    @Override
    public Mono<PersonaEntity> findById(Long id) {
        var persona = personaRepository.findById(id)
            .map(p -> Mono.just(p))
            .orElse(Mono.empty());
        return persona;
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return Mono.fromRunnable(() -> personaRepository.deleteById(id)) ;
    }

    @Override
    public Mono<PersonaResponse> save(PersonaRequest personaRequest) {
        var persona = personaMapper.toEntity(personaRequest);
        personaRepository.save(persona);
        return Mono.just(personaMapper.toResponse(persona));
    }

    @Override
    public Mono<PersonaResponse> update(Long id, PersonaRequest personaRequest) {
        var persona = personaRepository.findById(id)
            .map(p -> {
                p.setDocumento(personaRequest.getDocumento());
                p.setNombre(personaRequest.getNombre());
                p.setApellido(personaRequest.getApellido());
                p.setEdad(personaRequest.getEdad());
                p.setFechaNacimiento(personaMapper.toEntity(personaRequest).getFechaNacimiento());
                return personaRepository.save(p);
            })
            .orElseThrow();
        return Mono.just(personaMapper.toResponse(persona));
    }

}

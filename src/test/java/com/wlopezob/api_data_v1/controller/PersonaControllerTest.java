package com.wlopezob.api_data_v1.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.service.PersonaService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class PersonaControllerTest {
    @InjectMocks
    PersonaController personaController;
    @Mock
    PersonaService personaService;

    @Test
    void testListReactive() {
        /// AAA
        /// Arrange
        List personaResponse = List.of(PersonaResponse.builder().
            id(1L).
            build());
        Mockito.when(personaService.getAllReactive()).thenReturn(Flux.fromIterable(personaResponse));    
        /// Act   
        Flux<PersonaResponse> result = personaController.listReactive();
        
        StepVerifier.create(result)
            .expectNextMatches(persona -> persona.getId() == 1L)
            .verifyComplete();
        /// Assert
    }
}

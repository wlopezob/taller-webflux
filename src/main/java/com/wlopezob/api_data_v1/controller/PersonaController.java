package com.wlopezob.api_data_v1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopezob.api_data_v1.model.dto.PersonaResponse;
import com.wlopezob.api_data_v1.service.PersonaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
  
  private final PersonaService personaService;

  @GetMapping
  public List<PersonaResponse> list() {
    return personaService.getAll();
  }
    
}

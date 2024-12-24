package com.wlopezob.api_data_v1.service;

import java.util.List;

import com.wlopezob.api_data_v1.model.dto.PersonaResponse;

public interface PersonaService {
    List<PersonaResponse> getAll();
}

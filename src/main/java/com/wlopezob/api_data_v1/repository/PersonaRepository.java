package com.wlopezob.api_data_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wlopezob.api_data_v1.model.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

}

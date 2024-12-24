package com.wlopezob.api_data_v1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaRequest {
    private Long id;
    private String documento;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String fechaNacimiento;

}

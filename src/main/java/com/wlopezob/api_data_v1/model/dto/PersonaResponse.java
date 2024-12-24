package com.wlopezob.api_data_v1.model.dto;


import java.util.Date;

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
public class PersonaResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Date fechaNacimiento;

}

package com.wlopezob.api_data_v1.model.enitity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "persona")
public class PersonaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="persona_seq")
    @SequenceGenerator(name="persona_seq", sequenceName="persona_seq", allocationSize=1)
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private Integer edad;
    private Date fechaNacimiento;
}
package com.ForoHub.Foro.Api.Domain.Estados;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "estado")
@Entity(name = "EstadosApi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idstado")
public class EstadosApi {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idstado;
    private String  estado;
    private LocalDateTime dateregister;
}

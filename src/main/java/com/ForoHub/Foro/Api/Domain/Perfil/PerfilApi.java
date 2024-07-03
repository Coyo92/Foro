package com.ForoHub.Foro.Api.Domain.Perfil;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "perfil")
@Entity(name = "PerfilApi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idperfil")
public class PerfilApi {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idperfil;
    private int nombre;
    private int status;
    private LocalDateTime dateregister;
}

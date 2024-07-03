package com.ForoHub.Foro.Api.Controller;


import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RegisterRespuestaData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaApi;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaRepository;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.Validations.InterfValidateRespuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respuesta")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    List<InterfValidateRespuesta> validatorRespuesta;

    //Register New Respuesta
    @PostMapping
    @Transactional
    @Operation(summary = "Registrando una respuesta a un topico")
    public ResponseEntity<RegisterRespuestaData> registerRespuesta(@RequestBody @Valid RespuestaData respuestaData,
                                                                   UriComponentsBuilder uriComponentsBuilder) {
        validatorRespuesta.forEach ( v ->  v.validateRespuesta ( respuestaData ));
        int idRespuesta = respuestaRepository.getSecuenceRespuesta ();
        RespuestaApi saveRespuesta = respuestaRepository.save ( new RespuestaApi ( respuestaData, idRespuesta ) );
        RegisterRespuestaData registerUserData = new RegisterRespuestaData ( saveRespuesta.getIdrespuesta (),
                saveRespuesta.getMensaje (),
                saveRespuesta.getIdtopico (),
                saveRespuesta.getIduser (),
                saveRespuesta.getSolucion (),
                saveRespuesta.getDateregister ());
        URI url = uriComponentsBuilder.path ( "/respuesta/{idrespuesta}" ).buildAndExpand ( saveRespuesta.getIdrespuesta () ).toUri ();
        return ResponseEntity.created ( url ).body ( registerUserData );
    }

}

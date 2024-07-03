package com.ForoHub.Foro.Api.Controller;

import com.ForoHub.Foro.Api.Domain.Curso.CurseRepository;
import com.ForoHub.Foro.Api.Domain.Curso.ListCursoData;
import com.ForoHub.Foro.Api.Domain.Estados.EstadoRepository;
import com.ForoHub.Foro.Api.Domain.Estados.ListEstadoData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.ListRespData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.ListRespuestaData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaRepository;
import com.ForoHub.Foro.Api.Domain.Topico.Topico.*;
import com.ForoHub.Foro.Api.Domain.Topico.Topico.Validations.InterfValidateTopico;
import com.ForoHub.Foro.Api.Domain.Users.ListUserData;
import com.ForoHub.Foro.Api.Domain.Users.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    List<InterfValidateTopico> validatorsNewTopico;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private CurseRepository curseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    //Register New Topic
    @PostMapping
    @Transactional
    @Operation(summary = "Registra un nuevo Topico en la base de datos")
    public ResponseEntity<RegisterTopicoData> registerTopico(@RequestBody @Valid TopicoData topicoData,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        validatorsNewTopico.forEach ( v ->  v.validate ( topicoData ));
        int idTopico = topicoRepository.getSecuenceTopico();
        TopicoApi saveTopico = topicoRepository.save ( new TopicoApi(topicoData, idTopico));
        RegisterTopicoData registerTopicoData = new RegisterTopicoData ( saveTopico.getIdtopico (),
                saveTopico.getTitulo (),
                saveTopico.getMensaje (),
                saveTopico.getIduser (),
                saveTopico.getIdcurso (),
                saveTopico.getRespuesta (),
                saveTopico.getStatus (),
                saveTopico.getDateregister ());

        URI url = uriComponentsBuilder.path ( "/Topicos/{idtopico}" ).buildAndExpand ( saveTopico.getIdtopico ()
                    ).toUri ();
        return ResponseEntity.created ( url ).body ( registerTopicoData );
    }

    //Getting all Topicos
    @GetMapping
    @Operation(summary = "Obtiene Listado de Topicos.")
    public ResponseEntity<Page<ListTopicoData>> ListTopico(@PageableDefault(size = 10, page = 0) Pageable pageable ) {

        Page<ListTopicoData> listTopicoData = topicoRepository.findTopicoApiBy (pageable).map(ListTopicoData::new);

        return ResponseEntity.ok ( listTopicoData );
    }

    //Getting Topico for ID
    @GetMapping("/all")
    @Operation(summary = "Obtiene Listado de Topicos y sus respuestas.")
    public ResponseEntity<PageImpl<ApiForo>> ListTopicoRespuesta(@PageableDefault( size = 10, page = 0 ) Pageable pageable ) {

        List<ApiForo> listJson = getListTopico("ALL", 0);

        PageImpl<ApiForo> listaNueva =  new PageImpl<> ( listJson );

        return ResponseEntity.ok ( listaNueva );
    }

    //Getting Topico for ID
    @GetMapping("/{idtopico}")
    @Operation(summary = "Obtiene la informacion de topico por ID")
    public ResponseEntity<List<ApiForo>> getDataTopico(@PathVariable int idtopico) {

        List<ApiForo> listJson = getListTopico("ONE", idtopico);

        return ResponseEntity.ok ( listJson );
    }

    //Updating Topico for ID
    @PutMapping
    @Transactional
    @Operation(summary = "Actualizar topico")
    public ResponseEntity updateTopico(@RequestBody @Valid TopicoData topicoData) {

        validatorsNewTopico.forEach ( v ->  v.validateUpdate ( topicoData ));
        validatorsNewTopico.forEach ( v ->  v.validateSerchByIdTopico ( Math.toIntExact ( topicoData.idtopico () ) )  );
        TopicoApi topicoApi = topicoRepository.getReferenceById ( (long) topicoData.idtopico () );
        topicoApi.udpateTopicoApi ( topicoData );
        return ResponseEntity.ok ( new RegisterTopicoData ( topicoApi.getIdtopico (),
                topicoApi.getTitulo (),
                topicoApi.getMensaje ( ) ,
                topicoApi.getIduser (),
                topicoApi.getIdcurso (),
                topicoApi.getRespuesta (),
                topicoApi.getStatus (),
                topicoApi.getDateregister () ) );
    }

    //Delete or Change status Topico for ID
    @DeleteMapping("/{idtopico}")
    @Transactional
    @Operation(summary = "Inactivando topico por ID")
    public ResponseEntity CloseTopic(@PathVariable Long idtopico) {
        TopicoApi topicoApi = topicoRepository.getReferenceById ( idtopico );
        topicoApi.closeTopic();
        return ResponseEntity.noContent().build();
    }

    public List<ApiForo> getListTopico( String all, int id) {

        List<ListTopicoData> listTopicoData = null;

        if (Objects.equals ( all , "ALL" )) {

            listTopicoData = topicoRepository.findTopicoApiBy ( );

        }

        if (Objects.equals ( all , "ONE" )) {

            listTopicoData = topicoRepository.findTopicoApiByIdtopico ( id );

        }

        List<ApiForo> listApiForo = new ArrayList<> ( );

        assert listTopicoData != null;
        for (ListTopicoData listTopico : listTopicoData) {

            int idTopico = listTopico.idtopico ( );
            String titulo = listTopico.titulo ( );
            String mensaje = listTopico.mensaje ( );
            int iduser = listTopico.iduser ( );
            int idcurso = listTopico.idcurso ( );
            int idestado = listTopico.status ( );
            String status = getEstadoData( idestado );
            LocalDateTime fecha = listTopico.dateregister ( );

            //Obteniendo la informacion para los arreglos del topico
            List<ListRespData> respuesta = getListRespuestas(idTopico);
            List<ListCursoData> CursoData = getCursoData(idcurso);
            List<ListUserData> userData = getUserData(iduser);

            ApiForo apiForo = new ApiForo ( idTopico , titulo , mensaje , userData, CursoData , status , fecha ,
                    respuesta  );

            listApiForo.add ( apiForo );

        }

        return listApiForo;
    }

    public List<ListRespData> getListRespuestas(int idTopico) {

        List<ListRespuestaData> respuesta = respuestaRepository.findByIdtopico ( idTopico );

        List<ListRespData> listRespuestaData =new ArrayList<> ( );

        for (int i = 0; i < respuesta.size (); i++) {

            List<ListUserData> userData = getUserData ( respuesta.get ( i ).iduser () );

            ListRespData listRespData = new ListRespData (
                    respuesta.get ( i ).idrespuesta (),
                    respuesta.get ( i ).mensaje (),
                    respuesta.get ( i ).idtopico (),
                    userData,
                    respuesta.get ( i ).solucion (),
                    respuesta.get ( i ).dateregister ());

            listRespuestaData.add ( listRespData );
        }

        return listRespuestaData ;
    }

    public List<ListCursoData> getCursoData(int idCurso) {

        return curseRepository.findCursoApiByIdcurso( idCurso );
    }

    public List<ListUserData> getUserData(int idUser) {

        return userRepository.findUserApiByIduser( idUser );
    }

    public String getEstadoData(int idEstado) {

        return estadoRepository.getNombreEstadoById( idEstado );
    }

}

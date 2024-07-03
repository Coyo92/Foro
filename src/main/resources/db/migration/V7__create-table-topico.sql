create table if not exists mysqlalura.topico
(
    idtopico     numeric(30),
    titulo       varchar(200),
    mensaje      varchar(4000),
    iduser       numeric(10),
    idcurso      numeric(10),
    respuesta    varchar(4000),
    status       numeric(1),
    dateregister datetime,

    primary key pkTopicoIdTopico (idtopico),
    unique index idxTopicoTitulo (titulo),
    constraint ckTopicoTituloNN check ( titulo is not null),
    constraint ckTopicoMensajeNN check ( mensaje is not null),
    constraint ckTopicoIdUserjeNN check ( iduser is not null),
    constraint ckTopicoIdCursoNN check ( idcurso is not null),
    constraint ckTopicoRespuestaNN check ( respuesta is not null)
    );

grant references, select on table mysqlalura.topico to root@localhost;

alter table mysqlalura.topico add constraint
    fkIdCurso_Curso foreign key (idcurso) references mysqlalura.curso(idcurso);

alter table mysqlalura.topico add constraint
     fkIdUser_Curso foreign key (iduser) references mysqlalura.userApi(iduser);